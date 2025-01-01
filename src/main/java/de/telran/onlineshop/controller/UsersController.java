package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

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

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
        UserDto userResponse = usersService.updateUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userResponse);
    }


    @PostMapping
    public ResponseEntity<UserDto> insertUsers(@RequestBody UserDto userDto) {
        UserDto userResponse = usersService.insertUsers(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUsersById (@PathVariable Long id) {
        usersService.deleteUsersById(id);
    }


}