package de.telran.onlineshop.controller;

import de.telran.onlineshop.service.CartService;
import de.telran.onlineshop.dto.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getCartList() {
        List <Cart> carts = cartService.getCartList();
        return new ResponseEntity<>(carts,HttpStatus.valueOf(200));
    }

    @GetMapping(value = "/{id}")
    public Cart getCartByID(@PathVariable Integer id) {
        return cartService.getCartByID(id);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add")
    public Cart createCart(@RequestBody Cart newCart) {
        return cartService.createCart(newCart);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public Cart updateCart(@RequestBody Cart currentCart) {
        return cartService.updateCart(currentCart);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }


}
