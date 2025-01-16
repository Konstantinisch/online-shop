package de.telran.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Objects;

@Schema(description = "Data for user")
public class CartItemsDto {

    @Schema(description = "Unique Key of CartItem")
    @PositiveOrZero(message = "Invalid Id: must be greater than or equal to 0")
    private long cartItemId;
    private int cartId;
    private int productId;

    @NotEmpty
    private int quantity;

    public CartItemsDto() {
    }

    public CartItemsDto(long cartItemID, int cartID, int productID, int quantity) {
        this.cartItemId = cartItemID;
        this.cartId = cartID;
        this.productId = productID;
        this.quantity = quantity;
    }

    public long getCartItemsID() {
        return cartItemId;
    }

    public void setCartItemsID(long cartItemsID) {
        this.cartItemId = cartItemsID;
    }

    public int getCartID() {
        return cartId;
    }

    public void setCartID(int cartID) {
        this.cartId = cartID;
    }

    public int getProductID() {
        return productId;
    }

    public void setProductID(int productID) {
        this.productId = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemsDto cartItems = (CartItemsDto) o;
        return cartItemId == cartItems.cartItemId && cartId == cartItems.cartId && productId == cartItems.productId && quantity == cartItems.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemId, cartId, productId, quantity);
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "cartItemsID=" + cartItemId +
                ", cartID=" + cartId +
                ", productID=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
