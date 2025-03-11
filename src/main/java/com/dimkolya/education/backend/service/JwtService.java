package com.dimkolya.education.backend.service;

import com.dimkolya.education.backend.dto.jwt.JwtRequestDto;
import com.dimkolya.education.backend.dto.jwt.JwtResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final AuthenticationManager authenticationManager;
    private final JwtEncoder jwtEncoder;

    private static final Duration EXPIRATION_TIME = Duration.ofDays(1);

    private String generateToken(String username) {
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .subject(username)
                .expiresAt(Instant.now().plus(EXPIRATION_TIME))
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }

    public JwtResponseDto authenticate(JwtRequestDto requestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.username(), requestDto.password())
        );
        return new JwtResponseDto(generateToken(requestDto.username()));
    }
}
