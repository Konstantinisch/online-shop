package de.telran.onlineshop.controller;

import de.telran.onlineshop.service.CartItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orderItems")
@RequiredArgsConstructor
public class OrderItemsController {

    private final CartItemsService cartItemsService;

}
