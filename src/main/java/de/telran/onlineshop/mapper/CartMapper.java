//package de.telran.onlineshop.mapper;
//
//import de.telran.onlineshop.configure.MapperUtil;
//import de.telran.onlineshop.dto.CartDto;
//import de.telran.onlineshop.dto.CartItemsDto;
//import de.telran.onlineshop.dto.FavoritesDto;
//import de.telran.onlineshop.dto.UserDto;
//import de.telran.onlineshop.entity.CartEntity;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//
//@Component
//@RequiredArgsConstructor
//public class CartMapper {
//
//    private final ModelMapper modelMapper;
//    private final UserMapper userMapper;
//    private final CartItemsMapper cartItemsMapper;
//
//    public CartDto convertToCartDto(CartEntity cartEntity) {
//        CartDto cartDto = null;
//        if (cartEntity != null)
//            cartDto = modelMapper.map(cartEntity, CartDto.class); //автомат
//
////        if (cartEntity.getCartItems() != null) {
////            Set<CartItemsDto> cartItemsDtoSet = MapperUtil.convertSet(cartEntity.getCartItems(), cartItemsMapper::convertToCartItemsDto);
////            cartDto.setCartItems(cartItemsDtoSet);
////        }
////
////        UserDto userDto = userMapper.convertToUserDto(cartEntity.getUser()); // второй связанный объект
////        cartDto.setUser(userDto);
//        return cartDto;
//    }
//
//    public CartEntity convertToCartEntity(CartDto cartDto) {
//        CartEntity cartEntity = modelMapper.map(cartDto, CartEntity.class);
//        return cartEntity;
//    }
//}
