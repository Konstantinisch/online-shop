package de.telran.onlineshop.homework.lesson_131124;

import java.util.Objects;

public class CartItems {
    private int cartItemsID;
    private int cartID;
    private int productID;
    private int quantity;

    public CartItems() {
    }

    public CartItems(int cartItemsID, int cartID, int productID, int quantity) {
        this.cartItemsID = cartItemsID;
        this.cartID = cartID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getCartItemsID() {
        return cartItemsID;
    }

    public void setCartItemsID(int cartItemsID) {
        this.cartItemsID = cartItemsID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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
        CartItems cartItems = (CartItems) o;
        return cartItemsID == cartItems.cartItemsID && cartID == cartItems.cartID && productID == cartItems.productID && quantity == cartItems.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemsID, cartID, productID, quantity);
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "cartItemsID=" + cartItemsID +
                ", cartID=" + cartID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                '}';
    }
}
