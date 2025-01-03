package de.telran.onlineshop.service;

import de.telran.onlineshop.configure.MapperUtil;
import de.telran.onlineshop.dto.CartItemsDto;
import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.entity.CartItemsEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.mapper.CartItemsMapper;
//import de.telran.onlineshop.mapper.Mappers;
import de.telran.onlineshop.repository.CartItemsRepository;
import de.telran.onlineshop.repository.CartRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemsService {
    private final CartItemsRepository cartItemsRepository;
    private final CartRepository cartRepository;
    private final ProductsRepository productsRepository;
    private final CartItemsMapper mappers;

    // @PostConstruct
    void init() {

        ProductsEntity product1 = new ProductsEntity();
        product1 = productsRepository.save(product1);
        CartEntity cart1 = new CartEntity(null, 1);
        cart1 = cartRepository.save(cart1);
        CartItemsEntity cartItems1 = new CartItemsEntity(null, 5, cart1, product1);
        cartItemsRepository.save(cartItems1);


//        CartItemsEntity cartItemsEntity1 = new CartItemsEntity(null,4, null, null);
//        cartItemsRepository.save(cartItemsEntity1);
//        CartItemsEntity cartItemsEntity2 = new CartItemsEntity(null, 5, null, null);
//        cartItemsRepository.save(cartItemsEntity2);
//        CartItemsEntity cartItemsEntity3 = new CartItemsEntity(null, 6, null, null);
//        cartItemsRepository.save(cartItemsEntity3);

        System.out.println("The CartItemsRepository is created." + this.getClass().getName());
    }


    public List<CartItemsDto> getAllCartItems() {
        List<CartItemsEntity> cartItemsEntities = cartItemsRepository.findAll();
        List<CartItemsDto> cartItemsDtoList = MapperUtil.convertList(cartItemsEntities, mappers::convertToCartItemsDto);
        return cartItemsDtoList;
    }

    public CartItemsDto getCartItemsById(Long id) {
        CartItemsEntity cartItemsEntity = cartItemsRepository.findById(id).orElse(new CartItemsEntity());
        CartItemsDto cartItemsDto = mappers.convertToCartItemsDto(cartItemsEntity);
        return cartItemsDto;
    }

    public CartItemsDto updateCartItems(CartItemsDto cartItem) {
        CartItemsEntity cartItemsEntity = mappers.convertToCartItemsEntity(cartItem);

        CartItemsEntity returnCartItem = cartItemsRepository.save(cartItemsEntity);
        return mappers.convertToCartItemsDto(returnCartItem);

    }

    public CartItemsDto insertCartItems(CartItemsDto cartItem) {
        CartItemsEntity cartItemsEntity = mappers.convertToCartItemsEntity(cartItem);
        cartItemsEntity.setCartItemsId(null);
        CartItemsEntity savedCartItemsEntity = cartItemsRepository.save(cartItemsEntity);
        return mappers.convertToCartItemsDto(savedCartItemsEntity);
    }

    public void deleteCartItemsById(Long id) {
        CartItemsEntity cartItemsEntity = cartItemsRepository.findById(id).orElse(new CartItemsEntity());
        if (cartItemsEntity != null) {
            cartItemsRepository.delete(cartItemsEntity);
        }
    }

//    public List<CartItems> getAllCartItems() {
//        List<CartItemsEntity> cartItemsEntities = cartItemsRepository.findAll();
//        return cartItemsEntities.stream()
//                .map(entity -> new CartItems(entity.getCartItemsId(), entity.getCartId(),
//                        entity.getProductId(), entity.getQuantity()))
//                .collect(Collectors.toList());
//    }


}
