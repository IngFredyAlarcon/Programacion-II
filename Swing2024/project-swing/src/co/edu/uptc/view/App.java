package co.edu.uptc.view;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        FormStudent formStudent = new FormStudent();
        formStudent.setVisible(true);

        formStudent.setSize(400, 250);
        formStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        formStudent.getLabelFirstName().setText("Nombre");

    }
}
