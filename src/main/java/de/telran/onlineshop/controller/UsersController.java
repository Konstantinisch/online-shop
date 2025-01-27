package de.telran.onlineshop.controller;

import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.service.UsersService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
//@Tag(name = "Secret controller User", description = "Use for working with ")
public class UsersController implements UsersControllerInterface{

    private final UsersService usersService;

    @GetMapping  //select
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = usersService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.valueOf(200));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) throws FileNotFoundException {
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