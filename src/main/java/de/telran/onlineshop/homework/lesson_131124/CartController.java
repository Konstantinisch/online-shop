package de.telran.onlineshop.homework.lesson_131124;

import de.telran.onlineshop.model.Category;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    private List<Cart> cartList;

    @PostConstruct
    void init() {
        cartList = new ArrayList<>();
        cartList.add(new Cart(1, 4));
        cartList.add(new Cart(2, 3));
        cartList.add(new Cart(3, 2));
        cartList.add(new Cart(4, 1));
        cartList.add(new Cart(5, 7));

        System.out.println("This object is created " + this.getClass().getName());
    }

    @GetMapping
    List<Cart> getCartList() {
        return cartList;
    }

    @GetMapping(value = "/{id}")
    public Cart getCartbyID(@PathVariable Integer id) {
        return cartList.stream()
                .filter(cart -> cart.getCartID() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("cartID not found!"));

    }

    @PostMapping(value = "/add")
    public Cart createCart(@RequestBody Cart newCart) {
        newCart.setCartID(cartList.size() + 1);
        cartList.add(newCart);
        return newCart;
    }


    @PutMapping
    public Cart updateCart(@RequestBody Cart currentCart) {
        Cart cart1 = cartList.stream()
                .filter(cart -> cart.getCartID() == currentCart.getCartID())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("cartID not found!"));
        cart1.setUserID(currentCart.getUserID());
        return cart1;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable Long id) {
        Iterator<Cart> it = cartList.iterator();
        while (it.hasNext()) {
            Cart current = it.next();
            if (current.getCartID() == id) {
                it.remove();
            }
        }
    }
}
