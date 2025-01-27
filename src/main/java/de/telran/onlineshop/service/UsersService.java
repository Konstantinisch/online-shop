package de.telran.onlineshop.service;

import de.telran.onlineshop.configure.MapperUtil;
import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.entity.enums.Role;
//import de.telran.onlineshop.mapper.Mappers;
import de.telran.onlineshop.mapper.Mappers;
//import de.telran.onlineshop.mapper.UserMapper;
import de.telran.onlineshop.repository.CartRepository;
import de.telran.onlineshop.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final CartRepository cartRepository;
    private final Mappers mappers;

//    private List<UserDto> userList;


    //@PostConstruct
    void init() {
        CartEntity cart1 = new CartEntity();
        cart1 = cartRepository.save(cart1);
        UsersEntity user1 = new UsersEntity(null, "Вася Пупкин", "a@test.us", "1111111", "12345", Role.CLIENT, cart1, null, null);
        usersRepository.save(user1);

        CartEntity cart2 = new CartEntity();
        cart2 = cartRepository.save(cart2);
        UsersEntity user2 = new UsersEntity(null, "Дуня Семенова", "a@test.us", "1111111", "12345", Role.ADMIN, cart2, null, null);
        usersRepository.save(user2);

        System.out.println("Выполняем логику при создании объекта " + this.getClass().getName());
    }


    public List<UserDto> getAllUsers() {
        List<UsersEntity> usersEntities = usersRepository.findAll();
        List<UserDto> userDtoList = MapperUtil.convertList(usersEntities, mappers::convertToUserDto);
        return userDtoList;
    }

    //используем converter
    public UserDto getUserById(Long id) throws FileNotFoundException {

        if(id<0) {
            throw new FileNotFoundException(id+" - не найдено!");
        }
        UsersEntity usersEntity = usersRepository.findById(id).orElse(new UsersEntity());
        UserDto userDto = mappers.convertToUserDto(usersEntity);
        return userDto;

//               return userList.stream()
//                        .filter(user -> user.getUserID()==id)
//                        .findFirst()
//                        .orElse(null);
    }

    public UserDto updateUser(UserDto user) {
        UsersEntity usersEntity = mappers.convertToUserEntity(user); // из Dto в Entity

        UsersEntity returnUserEntity = usersRepository.save(usersEntity); // сохранили в БД

        return mappers.convertToUserDto(returnUserEntity); //из Entity  в Dto
    }

//    public UserDto updateUser(UserDto user) {
//        UserDto result = userList.stream()
//                .filter(u -> u.getUserID() == user.getUserID())
//                .findFirst()
//                .orElse(null);
//        if (result != null) {
//            result.setName(user.getName());
//            result.setEmail(user.getEmail());
//            result.setPhoneNumber(user.getPhoneNumber());
//        }
//        return result;
//    }

    public UserDto insertUsers(UserDto usersDto) {
        UsersEntity usersEntity = mappers.convertToUserEntity(usersDto);

        usersEntity.setUserId(null);
        UsersEntity savedUsersEntity = usersRepository.save(usersEntity);

        return mappers.convertToUserDto(savedUsersEntity);
    }

    public void deleteUsersById(Long id) {
        UsersEntity usersEntity = usersRepository.findById(id).orElse(new UsersEntity());
        if (usersEntity != null) {
            usersRepository.delete(usersEntity);
        }
    }
}