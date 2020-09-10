package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Valid User user) {
        this.userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/login")
    public User userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        User loginUser = this.userService.loginUser(username, password);
        return loginUser;
    }
}
