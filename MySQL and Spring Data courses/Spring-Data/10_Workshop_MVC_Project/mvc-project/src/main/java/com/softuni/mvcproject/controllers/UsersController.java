package com.softuni.mvcproject.controllers;

import com.softuni.mvcproject.dtos.users.UserLoginDTO;
import com.softuni.mvcproject.dtos.users.UserRegisterDTO;
import com.softuni.mvcproject.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {


    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String usersLogin(){
        return "/user/login";
    }

    @GetMapping("/register")
    public String usersRegister(){
        return "/user/register";
    }

    @PostMapping("/login")
    public ModelAndView usersLoginPost(@Valid UserLoginDTO loginDTO, BindingResult bindingResult){

        if(loginDTO.getUsername().equals("admin") && loginDTO.getPassword().equals("admin")){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        }

        List<String> errors = bindingResult
                .getAllErrors()
                .stream()
                .map(e -> e.getObjectName() + " " + e.getDefaultMessage())
                .toList();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/login");
        modelAndView.addObject("errors", errors);

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView usersRegisterPost(@Valid UserRegisterDTO registerDTO, BindingResult bindingResult) {

        List<String> errors = bindingResult
                .getAllErrors()
                .stream()
                .map(e -> e.getObjectName() + " " + e.getDefaultMessage())
                .toList();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/register");
        modelAndView.addObject("errors", errors);

        UserRegisterDTO register = userService.register(registerDTO);

        if(register == null) {
//            redirect or do something
        }

        return modelAndView;
    }


    @GetMapping("/info/{id}")
    public String userInfo( @PathVariable("id") String id) {
        System.out.println(id);
        return "home";
    }
}
