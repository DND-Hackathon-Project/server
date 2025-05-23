package com.coderumi.server.repository;

import com.coderumi.server.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FestivalRepository extends JpaRepository<Festival, Long> {

    Optional<Festival> findByFestival(Long id);
}
