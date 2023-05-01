package com.example.demo.domain.numbox;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    //생성시 날짜 자동 생성
    @CreatedDate
    private LocalDate createDate;

    //수정시 날짜 자동 생성
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
