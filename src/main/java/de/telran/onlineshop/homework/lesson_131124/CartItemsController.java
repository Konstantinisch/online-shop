package de.telran.onlineshop.homework.lesson_131124;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/cartItems")
public class CartItemsController {

    private List<CartItems> cartItemsList;

    @PostConstruct
    void init() {
        cartItemsList = new ArrayList<>();
        cartItemsList.add(new CartItems(1, 1, 4, 7));
        cartItemsList.add(new CartItems(2, 2, 5, 8));
        cartItemsList.add(new CartItems(3, 3, 6, 9));
        cartItemsList.add(new CartItems(4, 4, 7, 10));

        System.out.println("The List is created." + this.getClass().getName());
    }

    @GetMapping
    List<CartItems> getCartItems2() {
        return cartItemsList;
    }

    @GetMapping(value = "/{id}")
    CartItems getCartItemsByID(@PathVariable int id) {
        return cartItemsList.stream()
                .filter(cartItems -> cartItems.getCartItemsID() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("cartItemID is not found"));
    }

    @PostMapping(value = "/add")
    CartItems createCartItems(@RequestBody CartItems newCartItems) {
        newCartItems.setCartItemsID(cartItemsList.size() + 1);
        cartItemsList.add(newCartItems);
        return newCartItems;
    }

    @PutMapping
    public CartItems updateCartItems(@RequestBody CartItems currentCartItems) {
        CartItems cartItems1 = cartItemsList.stream()
                .filter(cartItems -> cartItems.getCartItemsID() == currentCartItems.getCartItemsID())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("CartItemsID not found"));
        cartItems1.setProductID(currentCartItems.getProductID());
        return cartItems1;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCartItems (@PathVariable int id ) {
        Iterator<CartItems> iter = cartItemsList.iterator();
        while (iter.hasNext()){
            CartItems current = iter.next();
            if (current.getCartItemsID() == id) {
                iter.remove();
            }
        }
    }

    @PreDestroy
    void destroy () {
        System.out.println("Here we can do something more! " + this.getClass().getName());
    }


}
