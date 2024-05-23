package com.romeulima.crud_course.repositories;

import com.romeulima.crud_course.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    Optional<Course> findByName(String name);
}
