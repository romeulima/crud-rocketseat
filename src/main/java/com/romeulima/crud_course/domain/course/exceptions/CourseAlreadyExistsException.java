package com.romeulima.crud_course.domain.course.exceptions;

public class CourseAlreadyExistsException extends RuntimeException {

    public CourseAlreadyExistsException(String message){
        super(message);
    }
}
