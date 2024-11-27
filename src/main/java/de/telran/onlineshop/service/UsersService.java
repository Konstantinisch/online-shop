package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService {

    private List<UserDto> userList;

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

    public List<UserDto> getAllUsers() {
        List<UsersEntity> usersEntities = usersRepository.findAll();
        return usersEntities.stream()
                .map(entity -> new UserDto(entity.getUserId(), entity.getName(), entity.getEmail(),
                        entity.getPhoneNumber(), entity.getPasswordHash()))
                .collect(Collectors.toList());
    }



    public UserDto getUserById(Long id) {
        UsersEntity usersEntity = usersRepository.findById(id).orElse(new UsersEntity());
        return new UserDto(usersEntity.getUserId(), usersEntity.getName(), usersEntity.getEmail(),
                usersEntity.getPhoneNumber(), usersEntity.getPasswordHash());
    }

    public UserDto getUserByName(String name) {///users/get?name=Other,k=2
        //UsersEntity usersEntity = usersRepository.findByName(name);//use OQL
        UsersEntity usersEntity = usersRepository.findByNameNative(name); //use native SQL

        return new UserDto(usersEntity.getUserId(), usersEntity.getName(), usersEntity.getEmail(),
                usersEntity.getPhoneNumber(), usersEntity.getPasswordHash());
    }

    public boolean createUsers( UserDto newUser) { //insert
        UsersEntity createUserEntity = new UsersEntity(null, newUser.getName(), newUser.getEmail(),
                newUser.getPhoneNumber(), newUser.getPasswordHash());
        UsersEntity returnUserEntity = usersRepository.save(createUserEntity);


        return returnUserEntity.getUserId() != null;
    }

    public UserDto updateUsers(UserDto updUser) { //update
        UsersEntity createUserEntity = new UsersEntity(updUser.getUserId(), updUser.getName(),
                updUser.getEmail(), updUser.getPhoneNumber(), updUser.getPasswordHash());
        UsersEntity returnUserEntity = usersRepository.save(createUserEntity);
        //transformiruem dannie is Entity v DTO i vosvraschaem polsovatelju

        return new UserDto(returnUserEntity.getUserId(), returnUserEntity.getName(), returnUserEntity.getEmail(),
                returnUserEntity.getPhoneNumber(), returnUserEntity.getPasswordHash());
    }

    public void deleteUsers( Long id) { //delete
        //categoriesRepository.deleteById(id); // first variant realisazii menee informativno

        UsersEntity users = usersRepository.findById(id).orElse(null);
        if (users == null) {
            throw new RuntimeException("Net takogo objecta s id =" + id);
        } else {
            usersRepository.delete(users);
        }

    }
}
