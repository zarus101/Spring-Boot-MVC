package com.suraj.vedu.exception;

public class CourseNotFoundException extends  RuntimeException{
    public  CourseNotFoundException(String id){
        super("could not found the course with id" + id);
    }
}
