package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CartItemsDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "CartItems Box", description = "Endpoint for working with CartItems und giving it to Users",
        externalDocs = @ExternalDocumentation(
                description = "Link for external documentation",
                url = "http://web.de"))
public interface CartItemsControllerInterface {

    @Operation(summary = "All CartItems", description = "Let see all cartItems")
    public List<CartItemsDto> getAllCartItems();

    @Operation(summary = "Find CartItem by Id", description = "Possibility to find CartItem by Id ")
    public CartItemsDto getCartItemsById(
            @Parameter(description = "Identifier", required = true, example = "1")
            @PathVariable Long id);

    @Operation(summary = "Create a new CartItem", description = "Possibility to create a new CartItem")
    public CartItemsDto insertCartItems(@RequestBody @Valid CartItemsDto cartItem);

    @Operation(summary = "Delete a CartItem", description = "Possibility to delete a CartItem")
    public void deleteCartItemsById(@PathVariable Long id);
}
