package com.iconicthon.team9be.service;

import com.iconicthon.team9be.domain.MandatoryLecture;
import com.iconicthon.team9be.dto.MandatoryLectureDTO;
import com.iconicthon.team9be.dto.MandatoryLectureDTO.PrerequisiteDto;
import com.iconicthon.team9be.exception.NotFoundException;
import com.iconicthon.team9be.repository.MandatoryLectureRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MandatoryLectureService {

    private final MandatoryLectureRepository mandatoryLectureRepository;

    public MandatoryLectureService(MandatoryLectureRepository mandatoryLectureRepository) {
        this.mandatoryLectureRepository = mandatoryLectureRepository;
    }

    public List<MandatoryLectureDTO> searchMandatoryLection(String courseName) {
        List<MandatoryLecture> mandatoryLectures = mandatoryLectureRepository.findAllByCourseNameContaining(courseName)
                .orElseThrow(() -> new NotFoundException("mandatoryLecture", courseName, "검색한 강좌는 필수 강좌가 아닙니다."));

        List<MandatoryLectureDTO> result = mandatoryLectures.stream()
                .map(
                        mandatoryLecture -> MandatoryLectureDTO.builder()
                                .id(mandatoryLecture.getId())
                                .courseName(mandatoryLecture.getCourseName())
                                .credit(mandatoryLecture.getCredit())
                                .semester(mandatoryLecture.getSemester())
                                .subjectArea(mandatoryLecture.getSubjectArea())
                                .prerequisites(mandatoryLecture.getPrerequisites().stream()
                                        .map(
                                                pre -> PrerequisiteDto.builder()
                                                        .id(pre.getPreRequisite().getId())
                                                        .courseName(pre.getPreRequisite().getCourseName())
                                                        .credit(pre.getPreRequisite().getCredit())
                                                        .semester(pre.getPreRequisite().getSemester())
                                                        .subjectArea(pre.getPreRequisite().getSubjectArea())
                                                        .build()
                                        )
                                        .toList()
                                )
                                .build()
                )
                .toList();

        return result;
    }
}
