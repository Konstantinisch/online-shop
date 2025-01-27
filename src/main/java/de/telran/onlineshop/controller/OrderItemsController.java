package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.OrderItemsDto;
import de.telran.onlineshop.service.CartItemsService;
import de.telran.onlineshop.service.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orderItems")
@RequiredArgsConstructor
public class OrderItemsController implements OrderItemsControllerInterface{

    private final OrderItemsService orderItemsService;

    @GetMapping
    public List<OrderItemsDto> getAllOrderItems() {
        return orderItemsService.getAllOrderItems();
    }

    @GetMapping(value = "/{id}")
    public OrderItemsDto getOrderItemsById(@PathVariable Long id) {
        return orderItemsService.getOrderItemsById(id);
    }

    @PostMapping
    public OrderItemsDto updateOrderItems(@RequestBody OrderItemsDto orderItemsDto) {
        return orderItemsService.updateOrderItems(orderItemsDto);
    }

    @PutMapping
    public OrderItemsDto insertOrderItems(@RequestBody OrderItemsDto orderItemsDto) {
        return orderItemsService.insertOrderItems(orderItemsDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrderItems(@PathVariable Long id) {
        orderItemsService.deleteOrderItems(id);
    }
}
