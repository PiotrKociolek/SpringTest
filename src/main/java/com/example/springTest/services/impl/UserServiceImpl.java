package com.example.springTest.services.impl;

import com.example.springTest.exeptions.RequestedIdDoesNotExistException;
import com.example.springTest.models.documents.UserDocument;
import com.example.springTest.models.dtos.request.CreateUserRequestDto;
import com.example.springTest.models.dtos.response.UserDetailsResponseDto;
import com.example.springTest.repositories.UserRepository;
import com.example.springTest.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetailsResponseDto getUserDetailsResponseDtoById(final String id) {
        Optional<UserDocument> document = userRepository.findById(id);
        return document.map(this::mapUserDocumentToUserDetailsResponseDto).orElseThrow(RequestedIdDoesNotExistException::new);
    }

    @Override
    public void createUser(final CreateUserRequestDto dto) {
        UserDocument document = mapCreateUserRequestDtoToUserDocument(dto);
        userRepository.save(document);
    }

    private UserDetailsResponseDto mapUserDocumentToUserDetailsResponseDto(UserDocument document) {
        UserDetailsResponseDto dto = new UserDetailsResponseDto();
        dto.setId(document.getId());
        dto.setName(document.getName());
        dto.setSurname(document.getSurname());
        dto.setEmail(document.getEmail());
        dto.setUsername(document.getUsername());
        return dto;
    }

    private UserDocument mapCreateUserRequestDtoToUserDocument(CreateUserRequestDto dto) {
        UserDocument userDocument = new UserDocument();
        userDocument.setId(null);
        userDocument.setName(dto.getName());
        userDocument.setEmail(dto.getEmail());
        userDocument.setSurname(dto.getSurname());
        userDocument.setUsername(dto.getUsername());
        return userDocument;
    }
}
