package de.telran.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemsDto {
    private long orderItemsId;
    private long orderId;
    private long productId;
    private int quantity;
    private long priceAtPurchase;

}
