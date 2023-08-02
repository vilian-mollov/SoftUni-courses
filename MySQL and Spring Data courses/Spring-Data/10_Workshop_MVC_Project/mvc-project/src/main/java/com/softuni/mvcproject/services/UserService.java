package com.softuni.mvcproject.services;

import com.softuni.mvcproject.dtos.users.UserRegisterDTO;

public interface UserService {

    UserRegisterDTO register(UserRegisterDTO userRegisterDTO);

}
