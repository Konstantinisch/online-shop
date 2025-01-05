package de.telran.onlineshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OrderItems")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrderItemsEntity {

    @Id
    @Column(name = "OrderItemsID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemsId;

//    @Column(name = "OrderID")
//    private long orderId;

//    @Column(name = "ProductID")
//    private long productId;

    @Column(name = "Quantity")
    private long quantity;

    @Column(name = "PriceAtPurchase")
    private long priceAtPurchase;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private ProductsEntity products;
    
    @ManyToOne
    @JoinColumn(name = "OrderID")
    private OrdersEntity orders;

    public OrderItemsEntity(int i, int i1, int i2, int i3, ProductsEntity products1) {
    }
}
