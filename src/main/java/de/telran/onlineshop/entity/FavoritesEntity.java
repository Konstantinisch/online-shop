package de.telran.onlineshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Favorites")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class FavoritesEntity {

    @Id
    @Column(name = "FavoriteID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favoriteId;

//    @Column(name = "UserID")
//    private long userId;
//
//    @Column(name = "ProductID")
//    private long productId;

    @ManyToOne
    @JoinColumn(name="UserID")
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name="ProductID")
    private ProductsEntity productsFavorites;



}
