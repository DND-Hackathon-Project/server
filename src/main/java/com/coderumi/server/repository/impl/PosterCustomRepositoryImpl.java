package com.coderumi.server.repository.impl;

import com.coderumi.server.dto.PosterDto;
import com.coderumi.server.entity.Poster;
import com.coderumi.server.entity.QVote;
import com.coderumi.server.repository.PosterCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.coderumi.server.entity.QMember.member;
import static com.coderumi.server.entity.QPoster.poster;
import static com.coderumi.server.entity.QVote.vote;

@Repository
@RequiredArgsConstructor
public class PosterCustomRepositoryImpl implements PosterCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<PosterDto> searchPosters(String region, boolean isSelected) {

        return queryFactory.select(Projections.constructor(PosterDto.class,
                        poster.id,
                        poster.image_url,
                        vote.count().longValue(),
                        member.id,
                        member.nickname
                ))
                .from(poster)
                .leftJoin(poster.votes, vote)
                .leftJoin(poster.member, member)
                .where(region != null ? poster.festival.region.eq(region) : null)
                .where(isSelected ? poster.election.isNotNull() : null)
                .groupBy(poster.id)
                .fetch();
    }



}
