package com.example.demo.auth;


import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;

    public String getToken() {
        return token;
    }
}
