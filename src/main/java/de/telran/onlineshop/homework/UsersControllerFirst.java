package de.telran.onlineshop.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersControllerFirst {
    @GetMapping
    String getUsers(){
        return "Chao, we are Users, your Friends! We are really glad to be here and help you!!! ";
    }
}
