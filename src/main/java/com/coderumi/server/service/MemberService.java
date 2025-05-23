package com.coderumi.server.service;

import com.coderumi.server.common.apipayload.ErrorStatus;
import com.coderumi.server.common.exception.GeneralException;
import com.coderumi.server.dto.res.MemberRes;
import com.coderumi.server.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<Long> getMembers() {
        return memberRepository.findAll()
                .stream()
                .map(member -> member.getId())
                .toList();
    }

    @Transactional(readOnly = true)
    public MemberRes getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .map(MemberRes::from)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
