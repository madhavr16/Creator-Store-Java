package in.amantiwari.creatorstore.controllers;

import in.amantiwari.creatorstore.entities.Product;
import in.amantiwari.creatorstore.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return  productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        return  productService.updateProduct(id, product);
    }

    @GetMapping
    public List<Product> getALlProducts() {
        return  productService.getALlProducts();
    }

    @GetMapping("/{id}")
    public  Product getProductById(@PathVariable Long id) {
        return  productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public  void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
