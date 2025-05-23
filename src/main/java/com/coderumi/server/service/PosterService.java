package com.coderumi.server.service;

import com.coderumi.server.common.apipayload.ErrorStatus;
import com.coderumi.server.common.exception.GeneralException;
import com.coderumi.server.dto.PosterDto;
import com.coderumi.server.entity.Festival;
import com.coderumi.server.entity.Member;
import com.coderumi.server.entity.Poster;
import com.coderumi.server.repository.FestivalRepository;
import com.coderumi.server.repository.MemberRepository;
import com.coderumi.server.repository.PosterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PosterService {
    private final FestivalRepository festivalRepository;
    private final MemberRepository memberRepository;
    private final PosterRepository posterRepository;

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @Transactional
    public void uploadFile(Long festivalId, Long memberId, MultipartFile file) throws IOException {
        Festival festival = festivalRepository.findById(festivalId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.FESTIVAL_NOT_FOUND));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        String filePath = saveFile(file);

        savePoster(festival, member, filePath);
    }

    private void savePoster(Festival festival, Member member, String filePath) {
        Poster poster = new Poster(festival, member, filePath);
        posterRepository.save(poster);
    }

    private static String saveFile(MultipartFile file) throws IOException {
        String filePath = UPLOAD_DIR + UUID.randomUUID();
        file.transferTo(new File(filePath));
        return filePath;
    }

    public List<PosterDto> getPosters(Long festivalId) {
        return posterRepository.findByFestivalId(festivalId);
    }

    public List<PosterDto> searchPosters(String region, boolean isSelected) {
        return posterRepository.searchPosters(region, isSelected);
    }
}
