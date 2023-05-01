package com.example.demo.web;

import com.example.demo.domain.numbox.numBox;
import com.example.demo.web.dto.numbox.numBoxSaveRequestDto;
import com.example.demo.web.dto.numbox.numBoxUpdateRequestDto;
import org.junit.After;
import com.example.demo.domain.numbox.numBoxRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class numBoxApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private numBoxRepository numBoxRepository;

    @After
    public void tearDown() throws Exception{
        numBoxRepository.deleteAll();
    }

    @Test
    public void posts() throws Exception{
        //given
        numBoxSaveRequestDto requestDto = numBoxSaveRequestDto.builder()
                .name("name")
                .phoneNum("phoneNum")
                .build();

        String url = "http://localhost:" + port + "/member";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<numBox> all = numBoxRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo("name");
        assertThat(all.get(0).getPhoneNum()).isEqualTo("phoneNum");
    }

    @Test
    public void modify() throws Exception{
        //given
        numBox savedPosts = numBoxRepository.save(numBox.builder()
                .name("name")
                .phoneNum("phoneNum")
                .build());

        int updateId = savedPosts.getId();
        String expectedName = "name2";
        String expectedPhoneNum = "phoneNum2";

        numBoxUpdateRequestDto requestDto = numBoxUpdateRequestDto.builder()
                .name(expectedName)
                .phoneNum(expectedPhoneNum)
                .build();

        String url = "http://localhost:" + port + "/member/" + updateId;

        HttpEntity<numBoxUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan("0");

        List<numBox> all = numBoxRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(expectedName);
        assertThat(all.get(0).getPhoneNum()).isEqualTo(expectedPhoneNum);

    }
}
