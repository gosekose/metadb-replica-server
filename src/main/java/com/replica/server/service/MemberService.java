package com.replica.server.service;

import com.replica.server.domain.Member;
import com.replica.server.repository.MemberRepository;
import com.replica.server.service.dto.MemberDto;
import com.replica.server.service.dto.MemberInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(MemberDto memberDto) {
        return memberRepository.save(Member.builder().name(memberDto.getName())
                .age(memberDto.getAge()).build()).getId();
    }

    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public Member findByName(String name) {
        return memberRepository.findByName(name).orElseThrow();
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "members", key = "#name", cacheManager = "cacheManager")
    public List<MemberInfoDto> findAllByName(String name) {
        log.info("name = {}", name);
        return memberRepository.findAllByName(name)
                .stream()
                .map(MemberInfoDto::new)
                .collect(Collectors.toList());
    }


}
