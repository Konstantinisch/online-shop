package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CartDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Carts", description = "Carts for putting of cartItems",
        externalDocs = @ExternalDocumentation(description = "Link for external" +
                " documentation in Germany", url = "http://yahoo.de"
        )
)
public interface CartControllerInterface {
    @Operation(summary = "All Carts", description = "Позволяет получить все Carts")
    public ResponseEntity<List<CartDto>> getCartList();

    @Operation(summary = "Find cart by ID", description = "Let get Cart by Id")
    public CartDto getCartByID(
            @Parameter(description = "Identifier", required = true, example = "1")
            @PathVariable Integer id);

    @Operation(summary = "Create Cart", description = "Let us to create a new Cart")
    public CartDto createCart(@RequestBody @Valid CartDto newCart);

    @Hidden
    public void deleteCart(@PathVariable Long id);
}
