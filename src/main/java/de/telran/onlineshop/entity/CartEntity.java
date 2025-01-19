package de.telran.onlineshop.entity;

import de.telran.onlineshop.configure.MapperUtil;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Cart")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartID")
    private Long cartId;



    @OneToOne
    @JoinColumn(name = "UserID", referencedColumnName = "userId")
    private UsersEntity user;


    @OneToMany(mappedBy = "cart",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CartItemsEntity> cartItems = new HashSet<>();

    public CartEntity(Object o, Object o1) {
    }


    public long getCartId() {
        return cartId;
    }


}