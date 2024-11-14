package com.iconicthon.team9be.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "LectureSchedule")
public class LectureSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_schedule_id")
    private Long id; // 강의 일정 ID

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

    private String semester; // 개설 학기

    @ManyToOne
    @JoinColumn(name = "prerequisite_id")
    @JsonIgnore
    private LectureSchedule prerequisite; // 선수 과목

    @OneToMany(mappedBy = "prerequisite")
    @Builder.Default
    @JsonIgnore
    private List<LectureSchedule> dependents = new ArrayList<>(); // 후수 과목 목록
}

