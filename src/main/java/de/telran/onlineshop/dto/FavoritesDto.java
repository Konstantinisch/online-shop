package de.telran.onlineshop.dto;

import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.entity.UsersEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoritesDto {
    @PositiveOrZero(message = "Invalid Id: must be greater than or equal to 0")
    private Long favoriteId;
    private UserDto user;
    private ProductsDto product;
}
