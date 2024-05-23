package com.romeulima.crud_course.dto.course;

import com.romeulima.crud_course.domain.course.enums.Active;

import java.util.UUID;

public record CourseResponseDetailsDTO(
        UUID id,
        String name,
        String categoty,
        Active active
) {
}
