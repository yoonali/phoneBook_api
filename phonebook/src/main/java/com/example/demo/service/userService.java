package com.example.demo.service;


import com.example.demo.domain.user.User;
import com.example.demo.web.dto.user.UserLoginDto;
import com.example.demo.web.dto.user.UserResponseDto;
import com.example.demo.web.dto.user.UserSaveDto;
import com.example.demo.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class userService {

    private final UserRepository userRepository;
    /*private final PasswordEncoder passwordEncoder;

    public int create(UserSaveDto requestDto){
        User user = new User();
        user.setName(requestDto.getName());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        return userRepository.save(user).getId();
    }*/

    @Transactional
    public int create(UserSaveDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getId();
    }

    public UserResponseDto findById(int id){
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id="+ id));
        return new UserResponseDto(entity);
    }

    @Transactional
    public UserResponseDto login(UserLoginDto userLoginDto, int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id=" + id));
        String password = user.getPassword();
        if (password.equals(userLoginDto.getPassword())) {
            System.out.println("로그인 성공");
            return new UserResponseDto(user);
        } else {
            System.out.println("비밀번호를 다시 입력해주세요");
            return null;
        }
    }
}
