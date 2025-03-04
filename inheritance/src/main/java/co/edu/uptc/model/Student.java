package co.edu.uptc.model;

public class Student extends Person {
    private String studentId;

    public Student(String name, String lastName, int age, String studentId) {
        super(name, lastName, age);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public boolean save() {
        // Save the student in the database
        return true;
    }

    public boolean update() {
        // Update the student in the database
        return true;
    }

    public boolean delete() {
        // Delete the student from the database
        return true;
    }

}
