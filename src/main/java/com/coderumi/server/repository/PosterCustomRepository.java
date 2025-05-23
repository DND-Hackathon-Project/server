package com.coderumi.server.repository;

import com.coderumi.server.dto.PosterDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosterCustomRepository {

    List<PosterDto> searchPosters(String region, boolean isSelected);

}
