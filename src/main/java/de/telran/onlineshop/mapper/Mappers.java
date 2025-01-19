
package de.telran.onlineshop.mapper;

import de.telran.onlineshop.configure.MapperUtil;
import de.telran.onlineshop.dto.*;
import de.telran.onlineshop.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class Mappers {

    //@Autowired
    private final ModelMapper modelMapper;

    public UserDto convertToUserDto(UsersEntity usersEntity) {
//        modelMapper.typeMap(UsersEntity.class, UserDto.class)
//                .addMappings(mapper -> mapper.skip(UserDto::setCart)); // исключаем этот метод из работы
//        UserDto userDto = modelMapper.map(usersEntity, UserDto.class); //автомат
        UserDto userDto = new UserDto(
                usersEntity.getUserId(),
                usersEntity.getName(),
                usersEntity.getEmail(),
                usersEntity.getPhoneNumber(),
                usersEntity.getPasswordHash()
        );
        if (userDto.getPasswordHash() != null)
            userDto.setPasswordHash("***"); // замещаем данных

        // преобразовываем
        if (usersEntity.getFavorites()!=null) {
            Set<FavoritesDto> favoritesDtoSet = MapperUtil.convertSet(usersEntity.getFavorites(), this::convertToFavoritesDto);
            userDto.setFavorites(favoritesDtoSet);
        }
//
//        CartDto cartDto = convertToCartDto(usersEntity.getCart()); // второй связанный объект
//        userDto.setCart(cartDto);

//        if (usersEntity.getOrdersEntities()!=null) {
//            Set<OrdersDto> ordersDtoSet = MapperUtil.convertSet(usersEntity.getOrdersEntities(), this::convertOrdersDto);
//            userDto.set(ordersDtoSet);
//        }
        return userDto;


    }

    public CartDto convertToCartDto(CartEntity cartEntity) {
        CartDto cartDto = null;
        if (cartEntity != null)
            cartDto = modelMapper.map(cartEntity, CartDto.class); //автомат
        return cartDto;
    }

    public CartEntity convertToCartEntity(CartDto cartDto) {
        CartEntity cartEntity = modelMapper.map(cartDto, CartEntity.class);
        return cartEntity;
    }

    public FavoritesDto convertToFavoritesDto(FavoritesEntity favoritesEntity) {
        FavoritesDto favoritesDto = modelMapper.map(favoritesEntity, FavoritesDto.class); //автомат
        favoritesDto.setUser(null);
        return favoritesDto;
    }

    public FavoritesEntity convertToFavoritesEntity(FavoritesDto favoritesDto) {
        FavoritesEntity favoritesEntity = modelMapper.map(favoritesDto, FavoritesEntity.class);
        return favoritesEntity;
    }

    public UsersEntity convertToUserEntity(UserDto userDto) {
        UsersEntity usersEntity = modelMapper.map(userDto, UsersEntity.class); //автомат
        return usersEntity;
    }

    public CategoryDto convertToCategoriesDto(CategoriesEntity categoriesEntity) {
        CategoryDto categoryDto = modelMapper.map(categoriesEntity, CategoryDto.class);
        return categoryDto;
    }

    public CategoriesEntity convertToCategoriesEntity(CategoryDto categoryDto) {
        CategoriesEntity categoriesEntity = modelMapper.map(categoryDto, CategoriesEntity.class);
        return categoriesEntity;
    }

    public CartItemsDto convertToCartItemsDto(CartItemsEntity cartItemsEntity) {
        CartItemsDto cartItemsDto = modelMapper.map(cartItemsEntity, CartItemsDto.class);
        return cartItemsDto;
    }

    public CartItemsEntity convertToCartItemsEntity(CartItemsDto cartItemsDto) {
        CartItemsEntity cartItemsEntity = modelMapper.map(cartItemsDto, CartItemsEntity.class);
        return cartItemsEntity;
    }

    public OrderItemsDto converToOrderItemsDto(OrderItemsEntity orderItemsEntity) {
        OrderItemsDto orderItemsDto = null;
        if (orderItemsEntity != null)
            orderItemsDto = modelMapper.map(orderItemsEntity, OrderItemsDto.class);
        return orderItemsDto;
    }

    public OrderItemsEntity convertToOrderItemsEntity(OrderItemsDto orderItemsDto) {
        OrderItemsEntity orderItemsEntity = modelMapper.map(orderItemsDto, OrderItemsEntity.class);
        return orderItemsEntity;
    }

    public OrdersDto convertToOrdersDto (OrdersEntity ordersEntity) {
        modelMapper.typeMap(OrdersEntity.class, OrdersDto.class)
                .addMappings(mapper -> mapper.skip(OrdersDto::setContactPhone));
        OrdersDto ordersDto = modelMapper.map(ordersEntity, OrdersDto.class);
        return ordersDto;
    }

    public OrdersEntity convertToOrdersEntity(OrdersDto ordersDto) {
        OrdersEntity ordersEntity = modelMapper.map(ordersDto, OrdersEntity.class);
        return ordersEntity;
    }

    public ProductsDto convertToProductsDto(ProductsEntity productsEntity) {
        modelMapper.typeMap(ProductsEntity.class, ProductsDto.class)
                .addMappings(mapper -> mapper.skip(ProductsDto::setPrice));
        ProductsDto productsDto = modelMapper.map(productsEntity, ProductsDto.class);
        return productsDto;
    }

    public ProductsEntity convertToProductsEntity(ProductsDto productsDto) {
        ProductsEntity productsEntity = modelMapper.map(productsDto, ProductsEntity.class);
        return productsEntity;
    }

}
