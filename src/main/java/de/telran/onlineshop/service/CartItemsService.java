package de.telran.onlineshop.service;

import de.telran.onlineshop.entity.CartItemsEntity;
import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.model.CartItems;
import de.telran.onlineshop.model.Category;
import de.telran.onlineshop.repository.CartItemsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartItemsService {
    private final CartItemsRepository cartItemsRepository;

    @PostConstruct
    void init() {

        CartItemsEntity cartItemsEntity1 = new CartItemsEntity(null,4, 3, 5);
        cartItemsRepository.save(cartItemsEntity1);
        CartItemsEntity cartItemsEntity2 = new CartItemsEntity(null, 5, 4, 2);
        cartItemsRepository.save(cartItemsEntity2);
        CartItemsEntity cartItemsEntity3 = new CartItemsEntity(null, 6, 4, 7);
        cartItemsRepository.save(cartItemsEntity3);

        System.out.println("The CartItemsRepository is created." + this.getClass().getName());
    }

    public List<CartItems> getAllCartItems() {
        List<CartItemsEntity> cartItemsEntities = cartItemsRepository.findAll();
        return cartItemsEntities.stream()
                .map(entity -> new CartItems(entity.getCartItemsId(), entity.getCartId(),
                        entity.getProductId(), entity.getQuantity()))
                .collect(Collectors.toList());
    }


}
