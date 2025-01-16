package de.telran.onlineshop.controller;

import de.telran.onlineshop.service.CartService;
import de.telran.onlineshop.dto.CartDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController implements CartControllerInterface{

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getCartList() {
        List<CartDto> carts = cartService.cartList;
        return new ResponseEntity<>(carts,HttpStatus.valueOf(200));
    }

    @GetMapping(value = "/{id}")
    public CartDto getCartByID(@PathVariable Integer id) {
        return cartService.getCartByID(id);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add")
    public CartDto createCart(@RequestBody @Valid CartDto newCart) {
        return cartService.createCart(newCart);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public CartDto updateCart(@RequestBody @Valid CartDto currentCart) {
        return cartService.updateCart(currentCart);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }


}
