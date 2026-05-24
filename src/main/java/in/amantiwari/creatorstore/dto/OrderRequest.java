package in.amantiwari.creatorstore.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    @NotBlank(message = "Customer name can not be blank")
    private  String customerName;

    @NotBlank(message = "Customer email can not be blank")
    private  String customerEmail;

    @Valid
    @NotEmpty
    private List<OrderItemRequest> item;
}
