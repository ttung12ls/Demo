package com.example.demo.Controller;

import com.example.demo.Entity.Users;
import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    Users createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }
    @GetMapping
    List<Users> getAllUsers() {
       return userService.getAllUsers();
    }
    @GetMapping("/{userId}")
    Users getUserById(@PathVariable("userId") Integer userId) {
        return userService.getUser(userId);
    }
    @PutMapping("/{userId}")
    Users updateUser(@PathVariable Integer userId, @RequestBody UserUpdateRequest request) {
          return userService.updateUser(userId, request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
        return "User deleted";
    }
}
