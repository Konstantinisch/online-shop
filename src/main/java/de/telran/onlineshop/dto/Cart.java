package de.telran.onlineshop.dto;

import java.util.Objects;

public class Cart {
    private long cartID;
    private long userID;

    public Cart() {
    }

    public Cart(long cartID, long userID) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
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
