package co.edu.uptc.controller;

import co.edu.uptc.model.Course;

import java.util.ArrayList;

public class CourseController {
    private Course course;
    private static CourseController _instance;
    public CourseController()   {
        course=new Course();
    }

    public static CourseController getInstance()    {
     if(_instance==null) {
         _instance= new CourseController(); //singleton
     }
     return _instance;
    }

    public void saveCourse(String name,String code,int credits){
        course.setName(name);
        course.setCode(code);
        course.setCredits(credits);
        course.setStudents(new ArrayList<>());
    }
    public void editCourse(String name, String code, int credits) {
        course.setName(name);
        course.setCode(code);
        course.setCredits(credits);
    }
    public void addCourse(String name,String code,int credits)  {
        course.setName(name);
        course.setCode(code);
        course.setCredits(credits);
    }
    public void deleteCourse() {
        course = null;
    }
    public Course getCourse() {
        return course;
    }


}
