package com.replica.server.service;

import com.replica.server.domain.Member;
import com.replica.server.service.dto.MemberDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    @DisplayName("저장 및 조회하기")
    public void save_find() throws Exception {
        //given
        String memberName = "gose";

        //when
        Long memberId = memberService.save(new MemberDto(memberName));
        Member member = memberService.findById(memberId);

        //then
        Assertions.assertThat(member.getName()).isEqualTo(memberName);
    }


}