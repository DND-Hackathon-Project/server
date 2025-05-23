package com.coderumi.server.repository;

import com.coderumi.server.entity.Member;
import com.coderumi.server.entity.Poster;
import com.coderumi.server.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsByPosterAndMember(Poster poster, Member member);
}
