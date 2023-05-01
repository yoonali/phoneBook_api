package com.example.demo.domain.numBox;

import com.example.demo.domain.numbox.numBox;
import com.example.demo.domain.numbox.numBoxRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class numBoxRepositoryTest {

    @SpyBean
    numBoxRepository numBoxRepository;

    @After
    public void cleanup() {numBoxRepository.deleteAll();}

    @Test
    void contextLoads() {
        //given
        Long UserId = 0L;
        String name = "유저 이름";
        String phoneNum = "전화번호";

        numBoxRepository.save(numBox.builder()
                .name(name)
                .phoneNum(phoneNum)
                .build());

        //when
        List<numBox> numBoxList = numBoxRepository.findAll();

        //then
        numBox numBox = numBoxList.get(0);
        assertThat(numBox.getName()).isEqualTo(name);
        assertThat(numBox.getPhoneNum()).isEqualTo(phoneNum);

    }

    @Test
    public void BestTimeEntity() {
        //given
        LocalDateTime now = LocalDateTime.of(2023,4,29,0,0,0);
        numBoxRepository.save(numBox.builder()
                .name("유저 이름")
                .phoneNum("전화번호")
                .build());

        //when
        List<numBox> numBoxList = numBoxRepository.findAll();

        //then
        numBox numBox = numBoxList.get(0);

        System.out.println(">>>>>>>createDate" + numBox
                .getCreateDate()+", modifiedDate=" + numBox.getModifiedDate());

        assertThat(numBox.getCreateDate()).isAfter(LocalDate.from(now));
        assertThat(numBox.getModifiedDate()).isAfter(now);
    }


}
