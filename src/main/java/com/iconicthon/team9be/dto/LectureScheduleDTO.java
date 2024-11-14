package com.iconicthon.team9be.dto;

import lombok.Getter;
import lombok.Setter;

public class LectureScheduleDTO {
    private String courseCode; // 학수강좌번호
    private String courseName; // 교과목명
    private String gradeLevel; // 학년
    private String curriculum; // 교과과정
    private String subjectArea; // 교과영역구분
    private String instructorName; // 교원명
    private String remarks; // 비고
    private String campus; // 수업 캠퍼스
    private String classSchedule; // 요일 및 교시
    private String classRoom; // 강의실
    private Integer credit; // 학점
    private Integer thoeryCredit; // 이론 학점
    private Integer practiceCredit; // 실습 학점
    private Integer engineerDesignCredit; // 공학 설계 학점
    private String lectureType; // 강의 유형
    private String lectureCategory; // 강의 종류
    private String isEnglish; // 원어 강의 여부
    private String completionType; // 이수 구분
    private String openingCollege; // 개설 대학
    private String openingDepartment; // 개설 학부
    private String openingMajor; // 개설 학과
    private String englishCourseName; // 교과목 영문명

    @Getter
    @Setter
    public static class SearchRequest {
        private String curriculum; // 교과과정
        private String subjectArea; // 교과영역구분
        private String openingCollege; // 개설 대학
        private String openingDepartment; // 개설 학부
        private String openingMajor; // 개설 학과
        private String campus; // 수업 캠퍼스
        private String lectureCategory; // 강의 종류
        private String classSchedule; // 요일 및 교시
        private String instructorName; // 교원명

        private String keyword; // 학수강좌번호 OR 교과목명
    }
}
