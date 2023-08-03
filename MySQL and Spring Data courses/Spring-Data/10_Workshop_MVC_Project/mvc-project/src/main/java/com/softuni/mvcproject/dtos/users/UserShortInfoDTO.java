package com.softuni.mvcproject.dtos.users;

public class UserShortInfoDTO {

    private String username;

    public UserShortInfoDTO() {
    }

    public UserShortInfoDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
