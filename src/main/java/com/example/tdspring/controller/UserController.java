package com.example.tdspring.controller;

import java.util.List;
import javax.validation.Valid;

import com.example.tdspring.entities.AppUser;
import com.example.tdspring.exception.ResourceNotFoundException;
import com.example.tdspring.repository.AppUserRepository;
import com.example.tdspring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private AccountService accountService;

    @GetMapping("users")
    public List<AppUser> getUsersList() {

        return userRepository.findAll();
    }

    @GetMapping("users/{username}")
    private AppUser getUsersByUsername(@Valid @RequestBody String username) {
        return userRepository.findByUsername(username);}

    @PostMapping("users")
    public AppUser addUser(@Valid @RequestBody AppUser user) {
        return accountService.saveUser(user);
    }

    @DeleteMapping("users/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable(value="username") String username)
    {
        AppUser appUser;
        try{
            appUser=userRepository.findByUsername(username);
        } catch (ResourceNotFoundException rnfe) {
            throw new ResourceNotFoundException("user", "username", username);
        }
        userRepository.delete(appUser);
        return ResponseEntity.ok().build();
    }




}
