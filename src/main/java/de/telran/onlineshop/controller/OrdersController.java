package de.telran.onlineshop.controller;

//import de.telran.onlineshop.model.Orders;
import de.telran.onlineshop.model.Order;
import de.telran.onlineshop.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders/{id}")
public class OrdersController {

    private  OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }


    @GetMapping
    public List<Order> getAllOrders () {
        return ordersService.getAllOrders();
    }

//    @PostMapping
//    public Orders addOrder (@PathVariable Long id, @RequestParam Orders order) {
//        return  ordersService.addOrderToUser(id, order);
//    }

//        @GetMapping
//    public ResponseEntity<List<Orders>> getAllOrders(@PathVariable Long userId) {
//        User user = usersService.getUserById(userId);
//        return ResponseEntity.status(201).body(user.getOrdersList());
//    }
}
