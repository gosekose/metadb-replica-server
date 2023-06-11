package com.replica.server.service.dto;

import com.replica.server.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfoDto {

    private String name;
    private int age;

    public MemberInfoDto(Member member) {
        this.name = member.getName();
        this.age = member.getAge();
    }
}
