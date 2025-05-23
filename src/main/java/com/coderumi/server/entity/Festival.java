package com.coderumi.server.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String region;

    private String address;

    private LocalDate vote_deadline;

    public Festival(String name, String description, String region, String address, LocalDate vote_deadline) {
        this.name = name;
        this.description = description;
        this.region = region;
        this.address = address;
        this.vote_deadline = vote_deadline;
    }
}
