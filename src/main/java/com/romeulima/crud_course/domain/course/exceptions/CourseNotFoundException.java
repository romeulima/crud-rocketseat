package com.romeulima.crud_course.domain.course.exceptions;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(String message){
        super(message);
    }
}
