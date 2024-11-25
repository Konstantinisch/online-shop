package de.telran.onlineshop.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ordersFirst")
public class OrdersControllerFirst {

    @GetMapping
    String getOrders(){
        return "Hallo, we are here, your Orders";
    }
}
