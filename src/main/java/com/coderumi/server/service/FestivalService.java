package com.coderumi.server.service;

import com.coderumi.server.entity.Festival;
import com.coderumi.server.repository.FestivalRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FestivalService {

    private final FestivalRepository festivalRepository;
    private static final String filePath = "data/data.json";

    @Transactional
    public void init() {

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(resourceAsStream);
            JsonNode records = root.get("records");

            List<Festival> festivals = new ArrayList<>();

            for (JsonNode record : records) {
                String name = record.get("축제명").asText();
                String description = record.get("축제내용").asText();
                String address = record.get("소재지도로명주소").asText();

                String region = "";
                if (!address.isEmpty()) {
                    region = address.split(" ")[0];
                }

                Festival festival = new Festival(name, description, region, address, LocalDate.now());
                festivals.add(festival);
            }

            festivalRepository.saveAll(festivals);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
