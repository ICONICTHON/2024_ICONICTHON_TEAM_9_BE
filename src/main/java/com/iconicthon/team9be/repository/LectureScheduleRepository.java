package com.iconicthon.team9be.repository;

import com.iconicthon.team9be.domain.LectureSchedule;
import com.iconicthon.team9be.dto.LectureScheduleProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureScheduleRepository extends JpaRepository<LectureSchedule, Long> {

    @Query("""
        SELECT l FROM LectureSchedule l
        WHERE (:curriculum IS NULL OR l.curriculum = :curriculum)
          AND (:subjectArea IS NULL OR l.subjectArea = :subjectArea)
          AND (:openingCollege IS NULL OR l.openingCollege = :openingCollege)
          AND (:openingDepartment IS NULL OR l.openingDepartment = :openingDepartment)
          AND (:openingMajor IS NULL OR l.openingMajor = :openingMajor)
          AND (:campus IS NULL OR l.campus = :campus)
          AND (:lectureCategory IS NULL OR l.lectureCategory = :lectureCategory)
          AND (:classSchedule IS NULL OR l.classSchedule LIKE CONCAT('%', :classSchedule, '%'))
          AND (:instructorName IS NULL OR l.instructorName LIKE CONCAT('%', :instructorName, '%'))
          AND (:keyword IS NULL OR 
               l.courseName LIKE CONCAT('%', :keyword, '%') OR
               l.englishCourseName LIKE CONCAT('%', :keyword, '%') OR
               l.remarks LIKE CONCAT('%', :keyword, '%'))
    """)
    List<LectureSchedule> searchLectures(
            String curriculum, String subjectArea, String openingCollege,
            String openingDepartment, String openingMajor, String campus,
            String lectureCategory, String classSchedule, String instructorName,
            String keyword);
}
