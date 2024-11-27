package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping  //select
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = usersService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.valueOf(200));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = usersService.getUserById(id);
        return ResponseEntity.status(222).body(user);
    }

    @GetMapping(value = "/get")
    public UserDto getUserByName(@RequestParam String name) { ///categories/get?name=Other,k=2
        return usersService.getUserByName(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping //Jackson
    public boolean createUsers(@RequestBody UserDto newUser) { //insert
        return usersService.createUsers(newUser);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public UserDto updateUsers(@RequestBody UserDto updUser) { //update
        return usersService.updateUsers(updUser);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUsers(@PathVariable Long id) { //delete
        usersService.deleteUsers(id);
    }






}