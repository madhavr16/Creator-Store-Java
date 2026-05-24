package in.amantiwari.creatorstore.controllers;

import in.amantiwari.creatorstore.dto.OrderRequest;
import in.amantiwari.creatorstore.entities.Order;
import in.amantiwari.creatorstore.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@Valid @RequestBody OrderRequest orderRequest){
        return  orderService.createOrder(orderRequest);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getIndividualOrder(@PathVariable Long id){
        return orderService.getIndividualOrder(id);
    }
}
