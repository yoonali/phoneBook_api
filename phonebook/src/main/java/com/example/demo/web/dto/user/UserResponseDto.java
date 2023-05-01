package com.example.demo.web.dto.user;

import com.example.demo.domain.numbox.numBox;
import com.example.demo.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private  int id;
    private String name;
    private String password;

    public UserResponseDto(User entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getPassword();
    }

}
