package com.coderumi.server.service;

import com.coderumi.server.common.apipayload.ErrorStatus;
import com.coderumi.server.common.exception.GeneralException;
import com.coderumi.server.entity.Member;
import com.coderumi.server.entity.Poster;
import com.coderumi.server.entity.Vote;
import com.coderumi.server.repository.MemberRepository;
import com.coderumi.server.repository.PosterRepository;
import com.coderumi.server.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VoteService {
    private final PosterRepository posterRepository;
    private final MemberRepository memberRepository;
    private final VoteRepository voteRepository;

    @Transactional
    public void vote(Long posterId, Long memberId) {
        Poster poster = posterRepository.findById(posterId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.POSTER_NOT_FOUND));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        if (voteRepository.existsByPosterAndMember(poster, member))
            throw new GeneralException(ErrorStatus.VOTE_CONFLICT);

        saveVote(poster, member);
    }

    private void saveVote(Poster poster, Member member) {
        Vote vote = new Vote(poster, member);
        voteRepository.save(vote);
    }
}
