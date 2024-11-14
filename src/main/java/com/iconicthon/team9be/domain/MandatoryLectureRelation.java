package com.iconicthon.team9be.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class MandatoryLectureRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 후수 과목
    @ManyToOne
    @JoinColumn(name = "post_requisite_id", nullable = false)
    private MandatoryLecture postRequisite;

    // 선수 과목
    @ManyToOne
    @JoinColumn(name = "pre_requisite_id", nullable = false)
    private MandatoryLecture preRequisite;
}
