package com.replica.server.service;

import com.replica.server.domain.Member;
import com.replica.server.repository.MemberRepository;
import com.replica.server.service.dto.MemberDto;
import com.replica.server.service.dto.MemberInfoDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    void clear() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("저장 및 조회하기")
    public void save_find() throws Exception {
        //given
        String memberName = "gose";

        //when
        Long memberId = memberService.save(new MemberDto(memberName, 100));
        Member member = memberService.findById(memberId);

        //then
        assertThat(member.getName()).isEqualTo(memberName);
    }

    @Test
    @DisplayName("캐시 저장 테스트")
    public void findMemberWithName() throws Exception {
        //given
        String name = "gosekose";
        for (int i = 0; i < 30; i++) {
            memberRepository.save(Member.builder().name(name).age(100 + i).build());
        }
        memberRepository.flush();
        //when
        List<MemberInfoDto> members1 = memberService.findAllByName(name);
        List<MemberInfoDto> members2 = memberService.findAllByName(name);

        //then
        assertThat(members1.size()).isEqualTo(members2.size());
    }
}