package com.iconicthon.team9be.controller;

import com.iconicthon.team9be.domain.MandatoryLecture;
import com.iconicthon.team9be.dto.MandatoryLectureDTO;
import com.iconicthon.team9be.service.MandatoryLectureService;
import com.iconicthon.team9be.util.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mandatorys")
public class MandatoryLectureController {

    private final MandatoryLectureService mandatoryLectureService;

    public MandatoryLectureController(MandatoryLectureService mandatoryLectureService) {
        this.mandatoryLectureService = mandatoryLectureService;
    }

    @GetMapping("/search")
    @Operation(summary = "특정 학과 과목 검색", description = "특정 학과(컴공)의 필수 과목들 중에서만 검색을 합니다.")
    public SuccessResponse<List<MandatoryLectureDTO>> searchLecturesForPathWay(@RequestParam("name") String courseName) {
        List<MandatoryLectureDTO> lectureScheduleProjection = mandatoryLectureService.searchMandatoryLection(courseName);

        return new SuccessResponse<>("특정 학과 과목 검색 성공", lectureScheduleProjection);
    }
}
