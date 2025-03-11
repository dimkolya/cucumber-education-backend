package com.dimkolya.education.backend.controller;

import com.dimkolya.education.backend.dto.user.UserDto;
import com.dimkolya.education.backend.dto.user.UserRegistrationRequestDto;
import com.dimkolya.education.backend.dto.user.UserRegistrationResponseDto;
import com.dimkolya.education.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/auth")
    public ResponseEntity<UserDto> auth(Authentication authentication) {
        return ResponseEntity.ok(userService.getUserByUsername(authentication.getName()));
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponseDto> register(
            @Valid @RequestBody UserRegistrationRequestDto requestDto) {
        return ResponseEntity.ok(userService.registerUser(requestDto));
    }
}
