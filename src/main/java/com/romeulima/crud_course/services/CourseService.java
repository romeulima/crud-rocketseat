package com.romeulima.crud_course.services;

import com.romeulima.crud_course.domain.course.Course;
import com.romeulima.crud_course.domain.course.enums.Active;
import com.romeulima.crud_course.domain.course.exceptions.CourseAlreadyExistsException;
import com.romeulima.crud_course.domain.course.exceptions.CourseNotFoundException;
import com.romeulima.crud_course.dto.course.CourseListResponseDTO;
import com.romeulima.crud_course.dto.course.CourseResponseDetailsDTO;
import com.romeulima.crud_course.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private final CourseRepository repository;

    public Course createCourse(Course course) {
        this.verifyCourseAlreadyExists(course.getName());

        return this.repository.save(course);
    }

    public CourseListResponseDTO getAllCourses(){
        List<Course> courses = this.repository.findAll();

        List<CourseResponseDetailsDTO> courseList = courses.stream().map(course -> new CourseResponseDetailsDTO(course.getId(), course.getName(), course.getCategory(), course.getActive())).toList();

        return new CourseListResponseDTO(courseList);
    }

    @Transactional
    public Course updateCourse(UUID id, Course body) {
        Course isCourseIdRegister = this.repository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found"));

        isCourseIdRegister.setName(body.getName());
        isCourseIdRegister.setCategory(body.getCategory());
        isCourseIdRegister.setActive(body.getActive());
        return isCourseIdRegister;
    }

    @Transactional
    public void deleteCourse(UUID id) {
        Course isCourseIdRegister = this.repository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found"));

        this.repository.delete(isCourseIdRegister);
    }

    private void verifyCourseAlreadyExists(String courseName) {
        Optional<Course> course = this.repository.findByName(courseName);
        if (course.isPresent()) throw new CourseAlreadyExistsException("This course already exists");
    }
}
