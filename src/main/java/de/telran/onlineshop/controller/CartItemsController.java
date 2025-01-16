package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CartItemsDto;
import de.telran.onlineshop.service.CartItemsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cartItems")
@RequiredArgsConstructor
public class CartItemsController implements CartItemsControllerInterface{

//    private List<CartItemsDto> cartItemsList;

    private final CartItemsService cartItemsService;

    @GetMapping
    public List<CartItemsDto> getAllCartItems() {
       return cartItemsService.getAllCartItems();
    }

    @GetMapping(value = "/{id}")
    public CartItemsDto getCartItemsById(@PathVariable Long id) {
        return cartItemsService.getCartItemsById(id);
    }

    @PutMapping
    public CartItemsDto updateCartItems(@RequestBody @Valid CartItemsDto cartItem) {
        return cartItemsService.updateCartItems(cartItem);
    }

    @PostMapping
    public CartItemsDto insertCartItems(@RequestBody @Valid CartItemsDto cartItem) {
        return cartItemsService.insertCartItems(cartItem);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCartItemsById(@PathVariable Long id) {
        cartItemsService.deleteCartItemsById(id);
    }


//    public CartItemsController(CartItemsService cartItemsService) {
//        this.cartItemsService = cartItemsService;
//    }



//    @GetMapping
//    public List<CartItems> getAllCartItems() {
//        return cartItemsService.getAllCartItems();
//    }

//    @GetMapping(value = "/{id}")
//    CartItems getCartItemsByID(@PathVariable int id) {
//        return cartItemsList.stream()
//                .filter(cartItems -> cartItems.getCartItemsID() == id)
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("cartItemID is not found"));
//    }
//
//    @PostMapping(value = "/add")
//    CartItems createCartItems(@RequestBody CartItems newCartItems) {
//        newCartItems.setCartItemsID(cartItemsList.size() + 1);
//        cartItemsList.add(newCartItems);
//        return newCartItems;
//    }
//
//    @PutMapping
//    public CartItems updateCartItems(@RequestBody CartItems currentCartItems) {
//        CartItems cartItems1 = cartItemsList.stream()
//                .filter(cartItems -> cartItems.getCartItemsID() == currentCartItems.getCartItemsID())
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("CartItemsID not found"));
//        cartItems1.setProductID(currentCartItems.getProductID());
//        return cartItems1;
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public void deleteCartItems (@PathVariable int id ) {
//        Iterator<CartItems> iter = cartItemsList.iterator();
//        while (iter.hasNext()){
//            CartItems current = iter.next();
//            if (current.getCartItemsID() == id) {
//                iter.remove();
//            }
//        }
//    }
//
//    @PreDestroy
//    void destroy () {
//        System.out.println("Here we can do something more! " + this.getClass().getName());
//    }


}
