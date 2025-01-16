package de.telran.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "OrderItems Data for user ")
public class OrderItemsDto {
    @Schema(description = "Unique key of OrderItems")
    private long orderItemsId;
    private long orderId;
    private long productId;

    @Schema(description = "How many OrderItems are in progress")
    private int quantity;
    private long priceAtPurchase;

}
