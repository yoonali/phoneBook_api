package com.example.demo.service;

import com.example.demo.domain.numbox.numBox;
import com.example.demo.web.dto.numbox.numBoxResponseDto;
import com.example.demo.web.dto.numbox.numBoxUpdateRequestDto;
import com.example.demo.domain.numbox.numBoxRepository;
import com.example.demo.web.dto.numbox.numBoxSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class numBoxService {
    private final numBoxRepository numBoxRepository;

    @Transactional
    public int save(numBoxSaveRequestDto requestDto){
        return numBoxRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public int update(int id, numBoxUpdateRequestDto requestDto) {
        numBox numbox = numBoxRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id="+ id));

        numbox.update(requestDto.getName(), requestDto.getPhoneNum());

        return id;
    }

    public List<numBox> findAll(){
        return numBoxRepository.findAll();
    }

    public numBoxResponseDto findById(int id){
        numBox entity = numBoxRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id="+ id));
        return new numBoxResponseDto(entity);
    }

    @Transactional
    public int delete(int id) {
        numBox entity = numBoxRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 id의 게시글입니다."));
        numBoxRepository.deleteById(id);
        return entity.getId();

    }
}
