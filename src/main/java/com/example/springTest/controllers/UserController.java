package com.example.springTest.controllers;

import com.example.springTest.models.dtos.request.CreateUserRequestDto;
import com.example.springTest.models.dtos.response.UserDetailsResponseDto;
import com.example.springTest.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/request/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public UserDetailsResponseDto getUserDetailsResponseDtoById(@PathVariable("id") String id) {
        return userService.getUserDetailsResponseDtoById(id);
    }

    @PutMapping(value = "/request/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createNewUser(@RequestBody CreateUserRequestDto dto) {
        userService.createUser(dto);
    }

}
