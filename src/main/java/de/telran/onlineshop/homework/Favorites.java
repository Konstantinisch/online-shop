package de.telran.onlineshop.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Favorites")
public class Favorites {

    @GetMapping
    String getFavorites(){
        return "Hi, Hi, Hi! Be happy with us!";
    }

    @GetMapping(value = "/things")
    String getFavorites2(){
        return "How many things would you like to bye?";
    }

    @GetMapping(value = "/things/number")
    int getNumberOfThings(){
        return 12;
    }
}
