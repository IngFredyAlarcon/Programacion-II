package co.edu.uptc.view;


import co.edu.uptc.controller.CourseController;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
   private static CourseController courseController;

    public static void main(String[] args)  {
       courseController=new CourseController();

        FormMain formMain= new FormMain();
        formMain.setSize(600,400);
        formMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formMain.setVisible(true);

/*
        FormCourse formCourse=new FormCourse();
        formCourse.getLabelName().setText("Nombre del curso");
        formCourse.getTextFieldCredits().setText("0");
        formCourse.setVisible(true);

        formCourse.setSize(400,250);
        formCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String name=formCourse.getTextFileName().getText();
        String code=formCourse.getTextFieldCode().getText();
        int credits=Integer.parseInt(formCourse.getTextFieldCredits().getText());

        formCourse.getButtonSave().addActionListener(null);

        courseController.saveCourse(name,code,credits);

        System.out.println(courseController.getCourse());


 */


    }



    }