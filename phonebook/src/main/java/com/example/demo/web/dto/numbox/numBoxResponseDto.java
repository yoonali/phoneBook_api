package com.example.demo.web.dto.numbox;

import com.example.demo.domain.numbox.numBox;
import lombok.Builder;
import lombok.Getter;

@Getter
public class numBoxResponseDto {
    private int id;
    private String name;
    private String phoneNum;


    public numBoxResponseDto(numBox entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.phoneNum = entity.getPhoneNum();
    }


}
