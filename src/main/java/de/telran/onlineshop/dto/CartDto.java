package de.telran.onlineshop.dto;

import java.util.Objects;
import java.util.Set;

public class CartDto {
    private long cartID;
    private long userID;

    private Set<CartItemsDto> cartItems;

    private UserDto user;

    public CartDto() {
    }

    public CartDto(long cartID, long userID) {
        this.cartID = cartID;
        this.userID = userID;
    }

    public long getCartID() {
        return cartID;
    }

    public void setCartID(long cartID) {
        this.cartID = cartID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setCartItems(Set<CartItemsDto> cartItems) {
        this.cartItems = cartItems;
    }

    public Set<CartItemsDto> getCartItems() {
        return cartItems;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto cart = (CartDto) o;
        return cartID == cart.cartID && userID == cart.userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartID, userID);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", userID=" + userID +
                '}';
    }
}
