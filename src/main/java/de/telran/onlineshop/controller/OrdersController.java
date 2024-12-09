package de.telran.onlineshop.controller;

//import de.telran.onlineshop.model.Orders;
import de.telran.onlineshop.dto.OrderDto;
import de.telran.onlineshop.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

    private  OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }


    @GetMapping
    public List<OrderDto> getAllOrders () {
        return ordersService.getAllOrders();
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        OrderDto order = ordersService.getOrderById(id);
        return ResponseEntity.status(222).body(order);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping //Jackson
    public boolean createOrders(@RequestBody OrderDto newOrder) { //insert
        return ordersService.createOrders(newOrder);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public OrderDto updateOrder(@RequestBody OrderDto updOrder) { //update
        return ordersService.updateOrders(updOrder);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrders(@PathVariable Long id) { //delete
       ordersService.deleteOrders(id);
    }



}
