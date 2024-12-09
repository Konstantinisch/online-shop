package de.telran.onlineshop.service;

import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.entity.CartItemsEntity;
import de.telran.onlineshop.dto.CartItems;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.repository.CartItemsRepository;
import de.telran.onlineshop.repository.CartRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartItemsService {
    private final CartItemsRepository cartItemsRepository;
    private final CartRepository cartRepository;
    private final ProductsRepository productsRepository;

    @PostConstruct
    void init() {

        ProductsEntity product1 = new ProductsEntity();
        product1 = productsRepository.save(product1);
        CartEntity cart1 = new CartEntity(null, 1);
        cart1 = cartRepository.save(cart1);
        CartItemsEntity cartItems1 = new CartItemsEntity(null, 5, cart1, product1 );
        cartItemsRepository.save(cartItems1);


//        CartItemsEntity cartItemsEntity1 = new CartItemsEntity(null,4, null, null);
//        cartItemsRepository.save(cartItemsEntity1);
//        CartItemsEntity cartItemsEntity2 = new CartItemsEntity(null, 5, null, null);
//        cartItemsRepository.save(cartItemsEntity2);
//        CartItemsEntity cartItemsEntity3 = new CartItemsEntity(null, 6, null, null);
//        cartItemsRepository.save(cartItemsEntity3);

        System.out.println("The CartItemsRepository is created." + this.getClass().getName());
    }

//    public List<CartItems> getAllCartItems() {
//        List<CartItemsEntity> cartItemsEntities = cartItemsRepository.findAll();
//        return cartItemsEntities.stream()
//                .map(entity -> new CartItems(entity.getCartItemsId(), entity.getCartId(),
//                        entity.getProductId(), entity.getQuantity()))
//                .collect(Collectors.toList());
//    }


}
