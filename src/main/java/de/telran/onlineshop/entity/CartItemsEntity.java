package de.telran.onlineshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CartItems")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CartItemsEntity {

    @Id
    @Column(name = "CartItemID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

//    @Column(name = "CartID")
//    private int cartId;

//    @Column(name = "ProductID")
//    private int productId;

    @Column(name = "Quantity")
    private int quantity;



    @ManyToOne
    @JoinColumn(name = "CartID")
    private CartEntity cart;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private ProductsEntity product;



}
