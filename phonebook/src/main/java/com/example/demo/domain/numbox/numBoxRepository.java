package com.example.demo.domain.numbox;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface numBoxRepository extends JpaRepository<numBox, Integer> {
    //<Entity 클래스 명, PK타입> 상속 -> 기본적인 CRUD(Create, Read, Update, Delete)메소드가 자동 생성

}
