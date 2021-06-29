package com.example.mavenpretest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user")
    public UserModel addUser(@RequestBody User user){
        System.out.println("Request Post");
        System.out.println(user);
        return service.addUser(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/{id}")
    public UserModel getUserById(@PathVariable String id){
        int _id = Integer.parseInt(id);
        System.out.println("Request Get");
        return service.getUserById(_id);
    }

}
