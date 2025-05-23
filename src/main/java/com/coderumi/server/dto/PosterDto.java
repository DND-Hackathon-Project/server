package com.coderumi.server.dto;

public record PosterDto(
        Long id,
        String imageUrl,
        Long voteCount
) {
}
