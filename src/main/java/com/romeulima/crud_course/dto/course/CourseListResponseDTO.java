package com.romeulima.crud_course.dto.course;

import java.util.List;

public record CourseListResponseDTO(
        List<CourseResponseDetailsDTO> coursesList
) {
}
