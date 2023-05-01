package com.example.demo.web;

import com.example.demo.domain.numbox.numBox;
import com.example.demo.service.numBoxService;
import com.example.demo.web.dto.numbox.numBoxSaveRequestDto;
import com.example.demo.web.dto.numbox.numBoxUpdateRequestDto;
import com.example.demo.web.dto.numbox.numBoxResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class numBoxApiController {

    private final numBoxService numBoxService;

    //전체 조회
    @GetMapping("/member")
    public List<numBox> findAll(){
        return numBoxService.findAll();
    }

    //등록
    @PostMapping("/member/save")
    public int save(@RequestBody numBoxSaveRequestDto requestDto){
        return numBoxService.save(requestDto);
    }

    //수정
    @PutMapping("/member/save/{id}")
    public int update(@PathVariable int id, @RequestBody numBoxUpdateRequestDto requestDto){
        return numBoxService.update(id, requestDto);
    }

    //조회
    @GetMapping("/member/save/{id}")
    public numBoxResponseDto findById (@PathVariable int id){
        return numBoxService.findById(id);
    }

    //삭제
    @DeleteMapping("/member/delete/{id}")
    public int delete(@PathVariable int id) {
        return numBoxService.delete(id);
    }

}
