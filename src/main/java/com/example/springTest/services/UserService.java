package com.example.springTest.services;

import com.example.springTest.models.dtos.request.CreateUserRequestDto;
import com.example.springTest.models.dtos.response.UserDetailsResponseDto;

public interface UserService {
    UserDetailsResponseDto getUserDetailsResponseDtoById(String id);

    void createUser(CreateUserRequestDto dto);
}
