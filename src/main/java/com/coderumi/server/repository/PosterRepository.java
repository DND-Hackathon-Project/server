package com.coderumi.server.repository;

import com.coderumi.server.dto.PosterDto;
import com.coderumi.server.entity.Poster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosterRepository extends JpaRepository<Poster, Long> {

    @Query("""
        SELECT new com.coderumi.server.dto.PosterDto(
            p.id,
            p.image_url,
            COUNT(v)
        )
        FROM Poster p
        LEFT JOIN p.votes v
        WHERE p.festival.id = :festivalId
        GROUP BY p.id
    """)
    List<PosterDto> findByFestivalId(Long festivalId);
}
