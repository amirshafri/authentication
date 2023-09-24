package com.triples.authentication.services;

import com.triples.authentication.dto.UserDto;
import com.triples.authentication.entities.User;
import com.triples.authentication.mappers.UserMapper;
import com.triples.authentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public boolean registerUser(UserDto userDto) {
        // Encode the user's password before saving it to the database
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userMapper.toModel(userDto);
        return userMapper.toDto(userRepository.save(user)).getId() != null;
    }
}
