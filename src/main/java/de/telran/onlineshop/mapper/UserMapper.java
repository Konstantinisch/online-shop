package de.telran.onlineshop.mapper;

import de.telran.onlineshop.configure.MapperUtil;
import de.telran.onlineshop.dto.CartDto;
import de.telran.onlineshop.dto.FavoritesDto;
import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.entity.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

//    @Lazy
    private final CartMapper cartMapper;

    private final FavoritesMapper favoritesMapper;

    public UserDto convertToUserDto(UsersEntity usersEntity) {
        modelMapper.typeMap(UsersEntity.class, UserDto.class)
                .addMappings(mapper -> mapper.skip(UserDto::setEmail)); // исключаем этот метод из работы
        UserDto userDto = modelMapper.map(usersEntity, UserDto.class); //автомат
        if (userDto.getPasswordHash() != null)
            userDto.setPasswordHash("***");

//        if (usersEntity.getFavorites()!=null) {
//            Set<FavoritesDto> favoritesDtoSet = MapperUtil.convertSet(usersEntity.getFavorites(), favoritesMapper::convertToFavoritesDto);
//            userDto.setFavorites(favoritesDtoSet);
//        }
//
//        CartDto cartDto = cartMapper.convertToCartDto(usersEntity.getCart()); // второй связанный объект
//        userDto.setCart(cartDto);
        return userDto;
    }

    public UsersEntity convertToUserEntity(UserDto userDto) {
        UsersEntity usersEntity = modelMapper.map(userDto, UsersEntity.class); //автомат
        return usersEntity;
    }



}
