package de.telran.onlineshop.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cartItemsFirst")
public class CartItemsControllerFirst {

    @GetMapping
    String getCartItems(){
        return "Hi, I'm your new CartItem";
    }

    @GetMapping(value = "/nextCartItems")
    String getCartItems2(){
        return "Hi, what is your favorite Item?";
    }
}
