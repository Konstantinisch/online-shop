package de.telran.onlineshop.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class Orders {

    @GetMapping
    String getOrders(){
        return "Hallo, we are here, your Orders";
    }
}
