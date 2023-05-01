package com.example.demo.domain.user;

import com.example.demo.domain.numbox.BaseTimeEntity;
import com.example.demo.domain.numbox.numBox;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users") //db에서 user는 예약어이기 때문에 users로 바꿔줌
public class User extends BaseTimeEntity {

    //기본키 생성을 데이터베이스에게 위임하는 방식으로 id값을 따로 할당하지 않아도
    // 데이터베이스가 자동으로 AUTO_INCREMENT를 하여 기본키를 생성

    /*@Column(name = "USER_ID")*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

  /* @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private List<numBox> numBoxList;

    public void addNumBox(numBox numbox) {
        if (numbox == null) numBoxList = new ArrayList<>();
        numBoxList.add(numbox);
    }*/

    @Column(length = 20 ,nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String name, String password){
        this.name = name;
        this.password = password;
    }
}
