package com.iconicthon.team9be.repository;

import com.iconicthon.team9be.domain.MandatoryLecture;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MandatoryLectureRepository extends JpaRepository<MandatoryLecture, Long> {

    Optional<List<MandatoryLecture>> findAllByCourseNameContaining(String courseName);


}
