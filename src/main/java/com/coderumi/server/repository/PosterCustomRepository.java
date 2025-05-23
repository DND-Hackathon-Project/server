package com.coderumi.server.repository;

import com.coderumi.server.dto.PosterDto;
import com.coderumi.server.entity.Poster;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PosterCustomRepository {

    List<PosterDto> searchPosters(String region, boolean isSelected);

    Optional<Poster> findHottestPosterByRegion(String region);
}
