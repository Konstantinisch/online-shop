package de.telran.onlineshop.controller;

//import de.telran.onlineshop.model.Orders;
import de.telran.onlineshop.dto.OrdersDto;
import de.telran.onlineshop.service.OrdersService;
import jakarta.validation.Valid;
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
    public List<OrdersDto> getAllOrders () {
        return ordersService.getAllOrders();
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdersDto> getOrderById(@PathVariable Long id) {
        OrdersDto order = ordersService.getOrderById(id);
        return ResponseEntity.status(222).body(order);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping //Jackson
    public boolean createOrders(@RequestBody @Valid OrdersDto newOrder) { //insert
        return ordersService.createOrders(newOrder);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public OrdersDto updateOrder(@RequestBody @Valid OrdersDto updOrder) { //update
        return ordersService.updateOrders(updOrder);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrders(@PathVariable Long id) { //delete
       ordersService.deleteOrders(id);
    }



}
