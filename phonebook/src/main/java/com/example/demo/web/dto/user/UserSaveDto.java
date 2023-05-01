package com.example.demo.web.dto.user;

import com.example.demo.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveDto {
    private String name;
    private String password;

    @Builder
    public UserSaveDto(String name, String password){
        this.name = name;
        this.password = password;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .password(password)
                .build();
    }
}
