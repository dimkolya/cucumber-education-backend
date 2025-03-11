package com.dimkolya.education.backend.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRegistrationRequestDto(
        @NotBlank
        @Size(min = 2, max = 20)
        @Pattern(regexp = "^[a-zA-Z0-9_]{2,20}$",
                message = "Username must be 2 to 20 characters long and can only contain letters, numbers, and underscores.")
        String username,

        @Email
        String email,

        @NotBlank
        @Size(min = 8, max = 64)
        @Pattern(regexp = "^[a-zA-Z0-9]{8,64}$",
                message = "Password must be 8 to 64 characters long and contain only letters and digits.")
        String password) {
}
