package com.coderumi.server.dto;

public record PosterDto(
        Long festivalId,

        Long posterId,
        String imageUrl,
        Long voteCount,

        Long memberId,
        String memberNickname
) {
}
