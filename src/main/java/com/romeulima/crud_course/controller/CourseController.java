package com.romeulima.crud_course.controller;

import com.romeulima.crud_course.domain.course.Course;
import com.romeulima.crud_course.dto.course.CourseListResponseDTO;
import com.romeulima.crud_course.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CourseController {

    @Autowired
    private final CourseService service;

    @PostMapping
    public ResponseEntity<Course> create(@Valid @RequestBody Course courseRequest) {

        Course course = this.service.createCourse(courseRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping
    public ResponseEntity<CourseListResponseDTO> readAllCourses() {
        CourseListResponseDTO courses = this.service.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable UUID id, @RequestBody Course body){
        Course updatedCourse = this.service.updateCourse(id, body);

        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable UUID id){
        this.service.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

}
