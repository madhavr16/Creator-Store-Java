package in.amantiwari.creatorstore.services;

import in.amantiwari.creatorstore.entities.Product;
import in.amantiwari.creatorstore.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct( Product product) {
        return  productRepository.save(product);
    }


    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product id does not exist" + id));

        existingProduct.setName(product.getName());
        existingProduct.setDescription((product.getDescription()));
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setStockQuantity(product.getStockQuantity());

        return  productRepository.save(existingProduct);
    }


    public List<Product> getALlProducts() {
        return  productRepository.findAll();
        // It will automatically return in the data type in which we are requesting(like here in List<>)
    }

    public  Product getProductById(Long id) {
        return  productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product does not exist"));
    }

    public  void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
