package com.iconicthon.team9be.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private Long id;

    private String courseCode;

    private String courseName;

    private Integer gradeLevel;

    private String curriculum;

    private String subjectArea;

    private String instructorName;

    private String remarks;

    private String campus;

    private String classSchedule; // 요일&교시

    private String classRoom;

    private Integer credit;

    private Integer thoeryCredit;

    private Integer practiceCredit;

    private Integer engineerDesignCredit;

    private String lectureType;

    private String lectureCategory;

    private Boolean isEnglish;

    private String completionType;

    private String openingCollege;

    private String openingDepartment;

    private String openingMajor;

    private String englishCourseName;

/*    @ManyToOne
    @JoinColumn(name = "lecture_schedule_id")
    private LectureSchedule child;*/
}
