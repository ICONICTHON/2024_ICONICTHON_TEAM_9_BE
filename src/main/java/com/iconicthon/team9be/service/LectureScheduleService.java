package com.iconicthon.team9be.service;

import com.iconicthon.team9be.domain.LectureSchedule;
import com.iconicthon.team9be.dto.LectureScheduleDTO.SearchRequest;
import com.iconicthon.team9be.repository.LectureScheduleRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LectureScheduleService {

    private final LectureScheduleRepository lectureScheduleRepository;

    public LectureScheduleService(LectureScheduleRepository lectureScheduleRepository) {
        this.lectureScheduleRepository = lectureScheduleRepository;
    }

    public List<LectureSchedule> searchLectures(SearchRequest request) {

        return lectureScheduleRepository.searchLectures(
                request.getCurriculum(),
                request.getSubjectArea(),
                request.getOpeningCollege(),
                request.getOpeningDepartment(),
                request.getOpeningMajor(),
                request.getCampus(),
                request.getLectureCategory(),
                request.getClassSchedule(),
                request.getInstructorName(),
                request.getKeyword()
        );
    }

}
