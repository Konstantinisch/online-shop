package de.telran.onlineshop.dto;

import de.telran.onlineshop.entity.CategoriesEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@Schema(description = "Data of Products for user")
public class ProductsDto {

    @PositiveOrZero(message = "Invalid productId: must be greater than or equal to 0")
    @Schema(description = "Unique key of Products")
    private Long productId;

    @Size(min = 2, max = 100, message = "Invalid name: must be of 2 - 100 characters ")
    @NotBlank
    @Schema(description = "Name of Product", example = "new Product")
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    private Double price;

    private String imageUrl;

    private Double discountPrice;

    private Timestamp createdAt;

    private Timestamp updatedAt;

}