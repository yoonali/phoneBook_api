package com.example.demo.web;


import com.example.demo.domain.user.User;
import com.example.demo.service.userService;
import com.example.demo.web.dto.user.UserLoginDto;
import com.example.demo.web.dto.user.UserResponseDto;
import com.example.demo.web.dto.user.UserSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@ResponseBody
@Controller
public class UserController {

    private final userService userService;

    @PostMapping("/user/signup")
    public int save(@RequestBody UserSaveDto requestDto) {
        return userService.create(requestDto);
    }

    @GetMapping("user/signup/{id}")
    public UserResponseDto findById (@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping("user/login/{id}")
    public UserResponseDto login(@RequestBody UserLoginDto userLoginDto, @PathVariable int id){
        return userService.login(userLoginDto,id);
    }
}
