package com.coderumi.server.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "festival_id")
    private Festival festival;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    public Poster(Festival festival, Member member, String image_url) {
        this.festival = festival;
        this.member = member;
        this.image_url = image_url;
    }

    @OneToMany(mappedBy = "poster", fetch = FetchType.LAZY)
    private List<Vote> votes = new ArrayList<>();

    @OneToOne(mappedBy = "poster", fetch = FetchType.LAZY)
    private Election election;
}
