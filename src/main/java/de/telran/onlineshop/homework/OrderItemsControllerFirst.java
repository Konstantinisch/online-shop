package de.telran.onlineshop.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orderItemsFirst")
public class OrderItemsControllerFirst {
    @GetMapping
    String getOrderItems(){
        return "Hi, we are your new Order Items. Are you happy?";
    }
}
