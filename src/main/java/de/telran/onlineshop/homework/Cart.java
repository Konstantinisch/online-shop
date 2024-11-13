package de.telran.onlineshop.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/request")
public class Cart {
    @GetMapping
    String getCartGet() {
        return "Hello, I'm a controller Cart!";
    }

    @GetMapping(value = "/cart")
    String getCartGet2(){
        return "Hello, I'm a controller Cart2!";
    }

    @GetMapping(value = "/cart/int")
    int getCartInt(){
        return 25;
    }
}