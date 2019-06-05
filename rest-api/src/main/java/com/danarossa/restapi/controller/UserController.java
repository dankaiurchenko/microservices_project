package com.danarossa.restapi.controller;

import com.danarossa.restapi.data.User;
import com.danarossa.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public Iterable<User> all() {
        return userService.all();
    }

    @PostMapping
    public Integer add(@RequestBody @Valid User newUser) {
        return userService.add(newUser);
    }

    @PutMapping("/{userId}")
    public void edit(@RequestBody @Valid User userToEdit) {
        userService.edit(userToEdit);
    }

    @DeleteMapping("/{userId}")
    public void edit(@PathVariable Integer userId) {
        userService.delete(userId);
    }

    @GetMapping("/{userId}")
    public User byId(@PathVariable Integer userId) {
        return userService.byId(userId);
    }


}
