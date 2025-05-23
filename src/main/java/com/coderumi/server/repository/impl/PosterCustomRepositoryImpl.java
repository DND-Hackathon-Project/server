package com.coderumi.server.repository.impl;

import com.coderumi.server.dto.PosterDto;
import com.coderumi.server.entity.Poster;
import com.coderumi.server.entity.QVote;
import com.coderumi.server.repository.PosterCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.coderumi.server.entity.QPoster.poster;
import static com.coderumi.server.entity.QVote.vote;

@Repository
@RequiredArgsConstructor
public class PosterCustomRepositoryImpl implements PosterCustomRepository {

    private final JPAQueryFactory queryFactory;




}
