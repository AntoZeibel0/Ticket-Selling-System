package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(User user){
        log.info("Saving user {} into the database", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUserById(Integer id){
        log.info("Deleting user with {} id", userRepository.findById(id));
        userRepository.delete(userRepository.findById(id).get());
    }

    public List<User> fetchUsers(){
        log.info("Fetching all users.");
        return userRepository.findAll();
    }

    public User updateUser(User user, Integer id){
        User userDB = userRepository.findById(id).get();

        if(Objects.nonNull(user.getUsername())
                && !"".equalsIgnoreCase(user.getUsername())){
            userDB.setUsername(user.getUsername());
        }

        if(Objects.nonNull(user.getPassword())
                && !"".equalsIgnoreCase(user.getPassword())){
            userDB.setPassword((user.getPassword()));
        }

        if(Objects.nonNull(user.getRole().name())
        && !"".equalsIgnoreCase(user.getRole().name())){
            userDB.setRole(user.getRole());
        }
        userDB.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(userDB);
    }
}
