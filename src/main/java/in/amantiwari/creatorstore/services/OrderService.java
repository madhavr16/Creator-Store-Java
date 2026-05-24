package in.amantiwari.creatorstore.services;

import in.amantiwari.creatorstore.dto.OrderItemRequest;
import in.amantiwari.creatorstore.dto.OrderRequest;
import in.amantiwari.creatorstore.entities.Order;
import in.amantiwari.creatorstore.entities.OrderItem;
import in.amantiwari.creatorstore.entities.Product;
import in.amantiwari.creatorstore.repositories.OrderRepository;
import in.amantiwari.creatorstore.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order createOrder(OrderRequest orderRequest){
        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRMED");

        for(OrderItemRequest itemRequest : orderRequest.getItem()){
            Product product = productRepository
                    .findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with this id " + itemRequest.getProductId()));

            if(product.getStockQuantity() < itemRequest.getQuantity()){
                throw new RuntimeException("Not enough stock to offer");
            }

            //Calculate total price
            BigDecimal priceOfItem = product.getPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.getQuantity()));

            totalPrice = totalPrice.add(priceOfItem);

            //Update product stock
            product.setStockQuantity(
                    product.getStockQuantity() - itemRequest.getQuantity()
            );

            productRepository.save(product);

            //Builder pattern to make obj
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();

            orderItems.add(orderItem);
        }
        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems);

        return  orderRepository.save(order);

    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getIndividualOrder(Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Please provide valid id" + id ));
    }
}
