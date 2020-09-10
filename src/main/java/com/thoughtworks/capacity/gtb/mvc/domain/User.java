package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Size(min = 3, max = 10, message = "You username length must be between 3 and 10 digits/letters")
    @NotEmpty(message="Username must not be blank")
    private String username;
    @Size(min = 5, max = 12, message = "You password length must be between 5 and 12 digits/letters")
    @NotEmpty(message="Password must not be blank")
    private String password;
    @Email(message = "You should use correct email format")
    private String email;
}
