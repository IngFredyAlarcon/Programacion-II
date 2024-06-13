package co.edu.uptc.model;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String id;

    public Student(String firstName, String lastName, String email, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String toString() {
        return "Student: " + getFullName() + " (" + id + ")";
    }

}
