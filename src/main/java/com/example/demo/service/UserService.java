package com.example.demo.service;

import com.example.demo.Entity.Users;
import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Users createUser(UserCreationRequest request) {
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setCreated_at(request.getCreated_at());
        user.setUpdated_at(request.getUpdated_at());

        return userRepository.save(user);
    }
    public Users updateUser(Integer userId, UserUpdateRequest request) {
        Users user = getUser(userId);
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
  
        return userRepository.save(user);

    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    public Users getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
   public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
   }
}
