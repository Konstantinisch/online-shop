package de.telran.onlineshop.service;

import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.model.Cart;
import de.telran.onlineshop.model.Category;
import de.telran.onlineshop.repository.CartRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {
    private List<Cart> cartList;

    private final CartRepository cartRepository;

    @PostConstruct
    void init() {
        CartEntity cart1 = new CartEntity(null,4);
        cartRepository.save(cart1);
        CartEntity cart2 = new CartEntity(null, 3);
        cartRepository.save(cart2);
        CartEntity cart3 = new CartEntity(null, 2);
        cartRepository.save(cart3);
        CartEntity cart4 = new CartEntity(null,1);
        cartRepository.save(cart4);
        CartEntity cart5 = new CartEntity(null, 7);
        cartRepository.save(cart5);




        System.out.println("This object is created " + this.getClass().getName());
    }

    public List<Cart> getCartList() {
        List<CartEntity> cartEntities = cartRepository.findAll();
        return cartEntities.stream()
                .map(entity -> new Cart(entity.getCartId(), entity.getUserId()))
                .collect(Collectors.toList());
    }

    public Cart getCartByID(@PathVariable Integer id) {
        return cartList.stream()
                .filter(cart -> cart.getCartID() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("cartID not found!"));

    }

    public Cart createCart(@RequestBody Cart newCart) {
        newCart.setCartID(cartList.size() + 1);
        cartList.add(newCart);
        return newCart;
    }

    public Cart updateCart(@RequestBody Cart currentCart) {
        Cart cart1 = cartList.stream()
                .filter(cart -> cart.getCartID() == currentCart.getCartID())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("cartID not found!"));
        cart1.setUserID(currentCart.getUserID());
        return cart1;
    }

    public void deleteCart(@PathVariable Long id) {
        Iterator<Cart> it = cartList.iterator();
        while (it.hasNext()) {
            Cart current = it.next();
            if (current.getCartID() == id) {
                it.remove();
            }
        }
    }

    @PreDestroy
    void destroyCart() {
        System.out.println(("There is a possibility to do a particular" +
                " Logic by this step! ") + this.getClass().getName());
    }
}
