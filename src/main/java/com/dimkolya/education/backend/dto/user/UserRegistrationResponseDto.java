package com.dimkolya.education.backend.dto.user;

import lombok.Data;

@Data
public class UserRegistrationResponseDto {
    private boolean success;
    private boolean usernameTaken;
    private boolean emailTaken;
    private String username;
    private String email;
}
