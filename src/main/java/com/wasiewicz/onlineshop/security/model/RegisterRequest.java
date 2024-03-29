package com.wasiewicz.onlineshop.security.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotEmpty(message = "The first name should not be empty")
    @NotNull(message = "The first name should not be empty")
    @Pattern(regexp = "^[a-zA-Z]{3,}$"
            , message = "The name should not contain numbers and must be at least 3 letters long")
    private String firstName;
    @NotEmpty(message = "The last name should not be empty")
    @NotNull(message = "The last name should not be empty")
    @Pattern(regexp = "^\\p{L}{3,}$"
            , message = "The lastname should not contain numbers and must be at least 3 letters long")
    private String lastName;
    @NotEmpty(message = "The email should not be empty")
    @NotNull(message = "The email should not be empty")
    @Email(message = "Enter a valid email address")
    private String email;
    @NotEmpty(message = "The password should not be empty")
    @NotNull(message = "The password should not be empty")
    @Size(min = 6, message = "The password must contain at least 6 characters")
    private String password;
}
