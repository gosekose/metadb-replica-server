package com.replica.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
public class Member implements Serializable {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private int age;
    @Builder
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
