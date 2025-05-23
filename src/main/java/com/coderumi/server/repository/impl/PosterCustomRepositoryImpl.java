package com.coderumi.server.repository.impl;

import com.coderumi.server.dto.PosterDto;
import com.coderumi.server.entity.Poster;
import com.coderumi.server.repository.PosterCustomRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.coderumi.server.entity.QElection.election;
import static com.coderumi.server.entity.QFestival.festival;
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

    @Override
    public Optional<Poster> findHottestPosterByRegion(String region) {
        List<Tuple> posterVotes = queryFactory
                .select(poster, vote.count())
                .from(vote)
                .join(vote.poster, poster)
                .join(poster.festival, festival)
                .join(election).on(election.poster.eq(poster)) // 당선된 포스터만
                .where(region != null ? festival.region.eq(region) : null) // region 조건 동적 처리
                .groupBy(poster)
                .fetch();

        return posterVotes.stream()
                .max(Comparator.comparingLong(t -> t.get(vote.count())))
                .map(t -> t.get(poster));
    }

}
