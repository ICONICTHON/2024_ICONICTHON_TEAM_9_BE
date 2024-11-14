package com.iconicthon.team9be.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureScheduleProjection {
    //강좌명
    //개설학기
    //선수후정보
    //is전필
    //교과과정(일반교양, 공통교양) -> 가능하면 교양or전공으로 분류

    private String courseName; // 과목명
    private String semester; // 학기
    private String subjectArea; // 교과 과정(일반교양, 공통교양, 전공, etc...)
    private Integer credit; // 학점

    //TODO: 선이수 과목명 리스트도 담겨야함.
}
