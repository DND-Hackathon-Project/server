package com.coderumi.server.dto.res;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class HottestPosterRes {
    private Long festivalId;

    private String posterImageUrl;

    public static HottestPosterRes of(Long festivalId, String posterImageUrl) {
        HottestPosterRes hottestPosterRes = new HottestPosterRes();
        hottestPosterRes.festivalId = festivalId;
        hottestPosterRes.posterImageUrl = posterImageUrl;
        return hottestPosterRes;
    }
}
