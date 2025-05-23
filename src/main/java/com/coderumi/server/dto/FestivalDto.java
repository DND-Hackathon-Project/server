package com.coderumi.server.dto;

import com.coderumi.server.entity.Festival;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class FestivalDto {
    private Long id;
    private String name;
    private String description;
    private String region;
    private String address;
    private LocalDate vote_deadline;
    private List<PosterDto> posterDtoList;

//    public static FestivalDto from(Festival festival) {
//        return new FestivalDto(
//                festival.getId(),
//                festival.getName(),
//                festival.getDescription(),
//                festival.getRegion(),
//                festival.getAddress(),
//                festival.getVote_deadline()
//        );
//    }
}
