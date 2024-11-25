package de.telran.onlineshop.model;

import java.util.Objects;

public class CartItems {
    private long cartItemsId;
    private int cartId;
    private int productId;
    private int quantity;

    public CartItems() {
    }

    public CartItems(long cartItemsID, int cartID, int productID, int quantity) {
        this.cartItemsId = cartItemsID;
        this.cartId = cartID;
        this.productId = productID;
        this.quantity = quantity;
    }

    public long getCartItemsID() {
        return cartItemsId;
    }

    public void setCartItemsID(long cartItemsID) {
        this.cartItemsId = cartItemsID;
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
        CartItems cartItems = (CartItems) o;
        return cartItemsId == cartItems.cartItemsId && cartId == cartItems.cartId && productId == cartItems.productId && quantity == cartItems.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemsId, cartId, productId, quantity);
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "cartItemsID=" + cartItemsId +
                ", cartID=" + cartId +
                ", productID=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
