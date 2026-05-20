package in.amantiwari.creatorstore.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name is required")
    @Column(name = "customer_name",nullable = false)
    private String customerName;

    @NotBlank(message = "Customer email is required")
    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private String status;

    @NotNull(message = "Total price is required")
    @DecimalMin(value = "0.0", message = "Total price must be greater than zero")
    @Column(name = "total_price",nullable = false)
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @PrePersist
    public  void  prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
