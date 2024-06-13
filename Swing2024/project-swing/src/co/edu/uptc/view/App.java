package co.edu.uptc.view;

import javax.swing.JFrame;

import co.edu.uptc.controller.CourseController;

public class App {
    private static CourseController courseController;
    public static void main(String[] args) throws Exception {
        courseController = new CourseController();
        // FormStudent formStudent = new FormStudent();
        // formStudent.setVisible(true);

        // formStudent.setSize(400, 250);
        // formStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // formStudent.getLabelFirstName().setText("Nombre");
        FormCourse formCourse = new FormCourse();
        formCourse.getLabelName().setText("Nombre del Curso");
        formCourse.getTextFieldCredits().setText("0");
        formCourse.setVisible(true);

        formCourse.setSize(400,250);
        formCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String name = formCourse.getTextFieldName().getText();
        String code = formCourse.getTextFieldCode().getText();
        int credits = Integer.parseInt(formCourse.getTextFieldCredits().getText());

        

    }
}
