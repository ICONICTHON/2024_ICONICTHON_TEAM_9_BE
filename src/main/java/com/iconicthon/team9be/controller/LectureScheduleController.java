package com.iconicthon.team9be.controller;

import com.iconicthon.team9be.domain.LectureSchedule;
import com.iconicthon.team9be.dto.LectureScheduleDTO.SearchRequest;
import com.iconicthon.team9be.service.LectureScheduleService;
import com.iconicthon.team9be.util.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lecture-schedules")
@Tag(name = "LectureSchedule", description = "강의 관련 API")
public class LectureScheduleController {

    private final LectureScheduleService lectureScheduleService;

    public LectureScheduleController(LectureScheduleService lectureScheduleService) {
        this.lectureScheduleService = lectureScheduleService;
    }

    @GetMapping("/search")
    @Operation(summary = "강의 검색", description = "여러 가지 조건으로 강의 검색합니다.")
    public SuccessResponse<List<LectureSchedule>> searchLectures(@ModelAttribute SearchRequest request) {
        List<LectureSchedule> lectureSchedules = lectureScheduleService.searchLectures(request);
        return new SuccessResponse<>("성공적으로 검색되었습니다.", lectureSchedules);
    }
}
