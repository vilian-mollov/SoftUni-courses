package com.softuni.mvcproject.services;

import com.softuni.mvcproject.dtos.users.UserRegisterDTO;
import com.softuni.mvcproject.entities.User;
import com.softuni.mvcproject.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserRegisterDTO register(UserRegisterDTO registerDTO) {

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(registerDTO, User.class );

        boolean isUsed = userRepository.existsByEmail(registerDTO.getEmail());

        if(isUsed) {
            return null;
        }

        userRepository.save(user);
        
        return registerDTO;
    }
}
