package de.telran.onlineshop.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cartFirst")
public class CartControllerFirst {
    @GetMapping
    String getCartGet() {
        return "Hello, I'm a controller Cart!";
    }

    @GetMapping(value = "/nextCart")
    String getCartGet2(){
        return "Hello, I'm a controller Cart2!";
    }

    @GetMapping(value = "/nextCart/int")
    int getCartInt(){
        return 25;
    }
}