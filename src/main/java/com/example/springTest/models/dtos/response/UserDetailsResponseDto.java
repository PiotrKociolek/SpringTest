package com.example.springTest.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsResponseDto {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String username;
}
