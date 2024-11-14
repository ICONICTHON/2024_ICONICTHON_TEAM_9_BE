package com.iconicthon.team9be.controller;

import com.iconicthon.team9be.domain.LectureSchedule;
import com.iconicthon.team9be.dto.LectureScheduleDTO.SearchRequest;
import com.iconicthon.team9be.service.LectureScheduleService;
import com.iconicthon.team9be.util.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "LectureSchedule", description = "강의 관련 API")
public class LectureScheduleController {

    private final LectureScheduleService lectureScheduleService;

    public LectureScheduleController(LectureScheduleService lectureScheduleService) {
        this.lectureScheduleService = lectureScheduleService;
    }

    @GetMapping("/lecture-schedules/search")
    @Operation(summary = "강의 검색", description = "여러 가지 조건으로 강의 검색합니다.")
    public SuccessResponse<List<LectureSchedule>> searchLectures(@ModelAttribute SearchRequest request) {
        List<LectureSchedule> lectureSchedules = lectureScheduleService.searchLectures(request);
        return new SuccessResponse<>("성공적으로 검색되었습니다.", lectureSchedules);
    }



    /**
     * [이수체계도 Initiating API]
     *
     * <p>사용자의 학과에 해당하는 모든 과목 데이터를 반환하는 API입니다.
     * 랜딩 페이지에서 특정 학과의 이수체계도를 클릭했을 때 호출됩니다.</p>
     *
     * <h3>TODO: API의 주요 목적</h3>
     * - 컴퓨터공학과의 모든 과목 데이터를 반환합니다.
     * - 반환 데이터는 중복을 제거한 distinct 데이터를 제공합니다.
     *
     * <h3>TODO: 반환 데이터 형식</h3>
     * API 호출 시 반환될 데이터는 다음과 같습니다:
     * <ul>
     *   <li><b>강좌명(courseName)</b>: 과목 이름</li>
     *   <li><b>개설학기(openingSemester)</b>: 과목이 개설되는 학기 정보</li>
     *   <li><b>선후수과목 목록(prerequisiteList)</b>: 선이수 또는 후속으로 연결된 과목 리스트</li>
     *   <li><b>필수 여부(isMandatory)</b>: 필수 과목 여부를 나타냄 (true/false)</li>
     *   <li><b>교과과정(curriculumType)</b>:
     *     <ul>
     *       <li>일반교양, 전공, 공통교양 등 교과과정 유형</li>
     *       <li>'전공' 또는 '교양'으로 구분</li>
     *     </ul>
     *   </li>
     * </ul>
     *
     * <h3>API 호출 방법</h3>
     * <pre>
     * GET /api/pathway/computer-science
     * Content-Type: application/json
     * </pre>
     *
     * <h3>TODO: 추가 고려 사항</h3>
     * <ul>
     *   <li>사용자 요청에 따라 필터링 및 정렬 지원</li>
     *   <li>학과 이름은 파라미터로 전달 가능 (ex: /pathway/{department})</li>
     *   <li>과목 데이터를 효율적으로 캐싱하여 성능 최적화</li>
     * </ul>
     *
     * <h3>사용 예시</h3>
     * 요청:
     * <pre>
     * GET /api/pathway/computer-science
     * </pre>
     * 응답:
     * <pre>
     * [
     *   {
     *     "courseName": "컴퓨터구조",
     *     "openingSemester": "2학년 1학기",
     *     "prerequisiteList": ["자료구조", "프로그래밍기초"],
     *     "isMandatory": true,
     *     "curriculumType": "전공"
     *   },
     *   {
     *     "courseName": "자료구조",
     *     "openingSemester": "1학년 2학기",
     *     "prerequisiteList": [],
     *     "isMandatory": false,
     *     "curriculumType": "전공"
     *   }
     * ]
     * </pre>
     *
     * @author YourName
     * @version 1.0
     * @since 2024-11-14
     */
/*    @GetMapping("/path-ways/{majorName}")
    public SuccessResponse<?> getLecturesForPathWay(@RequestParam(name = "majorName") String majorName) {
        lectureScheduleService.getLecturesForPathWay(majorName);
    }*/
}
