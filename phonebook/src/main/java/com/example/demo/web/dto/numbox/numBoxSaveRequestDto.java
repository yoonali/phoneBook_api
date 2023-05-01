package com.example.demo.web.dto.numbox;

import com.example.demo.domain.numbox.numBox;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class numBoxSaveRequestDto {
    private String name;
    private String phoneNum;

    @Builder
    public numBoxSaveRequestDto(String name, String phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public numBox toEntity(){
        return numBox.builder()
                .name(name)
                .phoneNum(phoneNum)
                .build();
    }
}
