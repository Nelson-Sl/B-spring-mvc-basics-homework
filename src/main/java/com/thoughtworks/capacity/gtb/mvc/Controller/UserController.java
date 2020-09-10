package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    public User userLogin(@RequestParam("username") @Size(min=3, max=10) @Pattern(regexp = "[_a-zA-Z0-9]+") String username,
                          @RequestParam("password") @Size(min=5, max=12) String password) {
        User loginUser = this.userService.loginUser(username, password);
        if(loginUser == null) {
            throw new UserNotFoundException("This user hasn't been registered yet. Please register");
        }
        return loginUser;
    }
}
