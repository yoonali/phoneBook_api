package com.example.demo.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginDto {
    private int id;
    private String name;
    private String password;

    @Builder
    public UserLoginDto(String name, String password){
        this.name = name;
        this.password = password;
    }
}
