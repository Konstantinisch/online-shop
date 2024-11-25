package de.telran.onlineshop.controller;

import de.telran.onlineshop.model.CartItems;
import de.telran.onlineshop.service.CartItemsService;
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

    private CartItemsService cartItemsService;

    public CartItemsController(CartItemsService cartItemsService) {
        this.cartItemsService = cartItemsService;
    }



    @GetMapping
    public List<CartItems> getAllCartItems() {
        return cartItemsService.getAllCartItems();
    }

//    @GetMapping(value = "/{id}")
//    CartItems getCartItemsByID(@PathVariable int id) {
//        return cartItemsList.stream()
//                .filter(cartItems -> cartItems.getCartItemsID() == id)
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("cartItemID is not found"));
//    }
//
//    @PostMapping(value = "/add")
//    CartItems createCartItems(@RequestBody CartItems newCartItems) {
//        newCartItems.setCartItemsID(cartItemsList.size() + 1);
//        cartItemsList.add(newCartItems);
//        return newCartItems;
//    }
//
//    @PutMapping
//    public CartItems updateCartItems(@RequestBody CartItems currentCartItems) {
//        CartItems cartItems1 = cartItemsList.stream()
//                .filter(cartItems -> cartItems.getCartItemsID() == currentCartItems.getCartItemsID())
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("CartItemsID not found"));
//        cartItems1.setProductID(currentCartItems.getProductID());
//        return cartItems1;
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public void deleteCartItems (@PathVariable int id ) {
//        Iterator<CartItems> iter = cartItemsList.iterator();
//        while (iter.hasNext()){
//            CartItems current = iter.next();
//            if (current.getCartItemsID() == id) {
//                iter.remove();
//            }
//        }
//    }
//
//    @PreDestroy
//    void destroy () {
//        System.out.println("Here we can do something more! " + this.getClass().getName());
//    }


}
