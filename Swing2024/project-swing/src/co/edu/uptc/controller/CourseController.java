package co.edu.uptc.controller;

import co.edu.uptc.model.Course;

public class CourseController {
    private Course course;

    public CourseController(){
        course = new Course();
    }

    public void saveCourse(String name, String code, int credits){
        course.setName(name);
        course.setCode(code);
        course.setCredits(credits);
    }

    public Course getCourse(){
        return course;
    }
    
}
