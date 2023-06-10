package com.replica.server.service;

import com.replica.server.domain.Member;
import com.replica.server.repository.MemberRepository;
import com.replica.server.service.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(MemberDto memberDto) {
        return memberRepository.save(Member.builder().name(memberDto.getName()).build()).getId();
    }

    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public Member findByName(String name) {
        return memberRepository.findByName(name).orElseThrow();
    }
}
