package de.telran.onlineshop.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tree")
public class CartItems {

    @GetMapping
    String getCartItems(){
        return "Hi, I'm your new CartItem";
    }

    @GetMapping(value = "/oak")
    String getCartItems2(){
        return "Hi, what is your favorite Item?";
    }
}
