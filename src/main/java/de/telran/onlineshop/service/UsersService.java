package de.telran.onlineshop.service;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.model.Category;
import de.telran.onlineshop.model.User;
import de.telran.onlineshop.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService {

    private List<User> userList;

    private final UsersRepository usersRepository;


    @PostConstruct
    void init() {
        UsersEntity usersEntity1 = new UsersEntity(null, "Вася Пупкин", "a@test.us",
                "1111111", "12345");
        usersRepository.save(usersEntity1);
        UsersEntity usersEntity2 = new UsersEntity(null, "Дуня Петрова", "duna@test.us",
                "2222222", "34567");



        System.out.println("Выполняем логику при создании объекта " + this.getClass().getName());
    }

    public List<User> getAllUsers() {
        List<UsersEntity> usersEntities = usersRepository.findAll();
        return usersEntities.stream()
                .map(entity -> new User(entity.getUserId(), entity.getName(), entity.getEmail(),
                        entity.getPhoneNumber(), entity.getPasswordHash()))
                .collect(Collectors.toList());
    }

    public User getUserById(Long id) {
        return userList.stream()
                .filter(user -> user.getUserId() == id)
                .findFirst()
                .orElse(null);
    }

    public User updateUser(User user) {
        User result = userList.stream()
                .filter(u -> u.getUserId() == user.getUserId())
                .findFirst()
                .orElse(null);
        if (result != null) {
            result.setName(user.getName());
            result.setEmail(user.getEmail());
            result.setPhoneNumber(user.getPhoneNumber());
        }
        return result;
    }
}
