package com.softuni.mvcproject.controllers;

import com.softuni.mvcproject.dtos.users.UserShortInfoDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestDemoController {

    @GetMapping("")
    public String getRest() {

        return "home";
    }


    @PostMapping("/create")
    public String create(@RequestBody UserShortInfoDTO userShortInfoDTO) {
        System.out.println(userShortInfoDTO.getUsername());
        return "home";
    }

    @GetMapping("/404")
    public ResponseEntity notFound() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/exception")
    public ResponseEntity exception() {
        throw new EntityNotFoundException("Custom message");
    }


}
