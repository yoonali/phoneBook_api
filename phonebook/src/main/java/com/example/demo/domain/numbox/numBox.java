package com.example.demo.domain.numbox;

import com.example.demo.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "numBox")
public class numBox extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

  /*  @Column( name = "USER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;*/

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String phoneNum;

    @Builder
    public numBox(String name, String phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public void update(String name, String phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }


}
