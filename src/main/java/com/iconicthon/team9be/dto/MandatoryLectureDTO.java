package com.iconicthon.team9be.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MandatoryLectureDTO {
    private Long id;
    private String courseName;
    private Integer credit;
    private Integer semester;
    private String subjectArea;
    private List<PrerequisiteDto> prerequisites;

    @Data
    @Builder
    public static class PrerequisiteDto {
        private Long id;
        private String courseName;
        private Integer credit;
        private Integer semester;
        private String subjectArea;
    }
}
