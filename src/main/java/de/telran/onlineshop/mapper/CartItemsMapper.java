//package de.telran.onlineshop.mapper;
//
//import de.telran.onlineshop.dto.CartItemsDto;
//import de.telran.onlineshop.entity.CartItemsEntity;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class CartItemsMapper {
//
//    private final ModelMapper modelMapper;
//
//
//    public CartItemsDto convertToCartItemsDto(CartItemsEntity cartItemsEntity) {
//        CartItemsDto cartItemsDto = modelMapper.map(cartItemsEntity, CartItemsDto.class);
//
//
//        return cartItemsDto;
//
//
//    }
//
//    public CartItemsEntity convertToCartItemsEntity(CartItemsDto cartItemsDto) {
//        CartItemsEntity cartItemsEntity = modelMapper.map(cartItemsDto, CartItemsEntity.class);
//        return cartItemsEntity;
//    }
//}
