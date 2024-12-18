package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.entity.enums.Role;
import de.telran.onlineshop.repository.CartRepository;
import de.telran.onlineshop.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final CartRepository cartRepository;

    private List<UserDto> userList;


    @PostConstruct
    void init() {
        CartEntity cart1 = new CartEntity();
        cart1 = cartRepository.save(cart1);
        UsersEntity user1 = new UsersEntity(null, "Вася Пупкин", "a@test.us", "1111111", "12345",  Role.CLIENT, cart1, null, null);
        usersRepository.save(user1);

        CartEntity cart2 = new CartEntity();
        cart2 = cartRepository.save(cart2);
        UsersEntity user2 = new UsersEntity(null, "Дуня Семенова", "a@test.us", "1111111", "12345",  Role.ADMIN, cart2, null, null);
        usersRepository.save(user2);

        System.out.println("Выполняем логику при создании объекта "+this.getClass().getName());
    }
    public List<UserDto> getAllUsers() {
        return userList;
    }

    public UserDto getUserById(Long id) {
        return userList.stream()
                .filter(user -> user.getUserID()==id)
                .findFirst()
                .orElse(null);
    }

    public UserDto updateUser(UserDto user) {
        UserDto result = userList.stream()
                .filter(u -> u.getUserID() == user.getUserID())
                .findFirst()
                .orElse(null);
        if(result!=null) {
            result.setName(user.getName());
            result.setEmail(user.getEmail());
            result.setPhoneNumber(user.getPhoneNumber());
        }
        return result;
    }
}