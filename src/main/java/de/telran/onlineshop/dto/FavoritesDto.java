package de.telran.onlineshop.dto;

import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.entity.UsersEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoritesDto {
    private long favoriteId;
    private UserDto user;
    private ProductsDto product;
}
