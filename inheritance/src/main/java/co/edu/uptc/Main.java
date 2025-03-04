package co.edu.uptc;

import co.edu.uptc.view.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentView studentView = new StudentView();
        studentView.printStudentDetails("John", "Doe", 25, "123456");
        studentView.printStudentCreated();
        studentView.printStudentSaved();
        studentView.printStudentUpdated();
        studentView.printStudentDeleted();
        studentView.printStudentNotDeleted();
        studentView.printStudentNotFound();
        studentView.printStudentNotUpdated();
        studentView.printStudentNotSaved();
        studentView.printStudentNotCreated();
    }
}