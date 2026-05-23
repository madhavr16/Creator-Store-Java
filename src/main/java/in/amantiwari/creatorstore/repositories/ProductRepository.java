package in.amantiwari.creatorstore.repositories;

import in.amantiwari.creatorstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
