package in.amantiwari.creatorstore.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class OrderItemRequest {
    @NotNull()
    private Long productId;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity should be greater than zero")
    private Integer quantity;

}
