package de.telran.onlineshop.dto;

import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.entity.UsersEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "Instrument for giving Data to users")
public class FavoritesDto {
    @PositiveOrZero(message = "Invalid Id: must be greater than or equal to 0")
    @Schema(description = "Unique key of each Favorite", example = "2", accessMode = Schema.AccessMode.AUTO)
    private Long favoriteId;
    private UserDto user;
    private ProductsDto product;
}
