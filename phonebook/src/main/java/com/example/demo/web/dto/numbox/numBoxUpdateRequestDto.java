package com.example.demo.web.dto.numbox;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class numBoxUpdateRequestDto {
    private String name;
    private String phoneNum;

    @Builder
    public numBoxUpdateRequestDto(String name, String phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }
}
