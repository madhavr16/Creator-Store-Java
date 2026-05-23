package in.amantiwari.creatorstore.repositories;

import in.amantiwari.creatorstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
