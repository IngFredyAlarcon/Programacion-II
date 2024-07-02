package co.edu.uptc.view;

import co.edu.uptc.controller.CourseController;
import co.edu.uptc.controller.StudentController;
import co.edu.uptc.model.Course;
import co.edu.uptc.model.Student;
import co.edu.uptc.util.FileManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormStudentEnrollCourse extends JFrame implements ActionListener {
    private JLabel labelStudent;
    private JTextField textFieldStudent;


    FileManagement fileManagement=new FileManagement();
    private JLabel labelElection; //etiqueta para elegir el curso
    private JLabel labelTitle;
    private JLabel labelName;
    private JLabel labelCode;
    private JLabel labelCredits;

    private JComboBox<Course> comoboxCourses; // Combobox para los cursos
    private JTextField textFieldName;
    private JTextField textFieldCode;
    private JTextField textFieldCredits;


    private JButton butonSave;
    private JButton buttonCancel;


    public FormStudentEnrollCourse(){
        this.initComponents();
    }

    private void initComponents() {
     labelStudent=new JLabel("Id Student");
     textFieldStudent=new JTextField();

        labelElection=new JLabel("Select Course");
        labelTitle=new JLabel("Course Information");
        labelName=new JLabel("Course Name");
        labelCode=new JLabel("Course Code");
        labelCredits=new JLabel("Course Credits");

        comoboxCourses=new JComboBox<Course>();

        textFieldName=new JTextField();
        textFieldCode=new JTextField();
        textFieldCredits=new JTextField();

        textFieldName.setEditable(false);
        textFieldCode.setEditable(false);
        textFieldCredits.setEditable(false);


        butonSave=new JButton("Save");
     buttonCancel=new JButton("Cancel");

        setLayout(null);

     labelStudent.setBounds(10,10,130,30);
     textFieldStudent.setBounds(120,10,200,30);
        labelElection.setBounds(10,50,130,30);
        labelTitle.setBounds(95,100,130,30);
        labelName.setBounds(10,140,130,30);
        labelCode.setBounds(10, 180, 100, 30);//Establece la posición y tamaño de la etiqueta código
        labelCredits.setBounds(10, 220, 100, 30);//Establece la posición y tamaño de la etiqueta créditos

        comoboxCourses.setBounds(120,50,200,30);

        textFieldName.setBounds(120, 140, 200, 30);//Establece la posición y tamaño del campo de texto del nombre
        textFieldCode.setBounds(120, 180, 200, 30);//Establece la posición y tamaño del campo de texto del código
        textFieldCredits.setBounds(120, 220, 200, 30);

        butonSave.setBounds(100,260,100,30);
        buttonCancel.setBounds(250,260,100,30);

        String path="src/co/edu/uptc/persistence/Cursos.json";
        String ContenidoCursos=fileManagement.readJsonFile(path);
        ArrayList<Course> cursos=fileManagement.deserealiseObjectCollectionFromJson2(ContenidoCursos,Course.class);
        for(Course curso:cursos){
            comoboxCourses.addItem(new Course(curso.getName(),curso.getCode(),curso.getCredits()));

        }
        comoboxCourses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course courseSelect= (Course) comoboxCourses.getSelectedItem();
                textFieldName.setText(courseSelect.getName());
                textFieldCode.setText(courseSelect.getCode());
                textFieldCredits.setText(String.valueOf(courseSelect.getCredits()));

            }
        });
        String contentEnd=fileManagement.serializeObjectCollectionToJson2(cursos);
        fileManagement.saveData(path,contentEnd);


        add(labelStudent);
        add(textFieldStudent);
        add(labelElection);
        add(labelTitle);
        add(labelName);
        add(labelCode);
        add(labelCredits);

        add(comoboxCourses);

        add(textFieldName);
        add(textFieldCode);
        add(textFieldCredits);

        add(buttonCancel);
        add(butonSave);

        butonSave.addActionListener(this);// Añade un evento al botón de guardar
        buttonCancel.addActionListener(this);

        setSize(350, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==butonSave) {

    String id=textFieldStudent.getText();
    Course courseSelect= (Course) comoboxCourses.getSelectedItem();
    String path="src/co/edu/uptc/persistence/Estudiantes.json";
    String contenidoJson=fileManagement.readJsonFile(path);
    ArrayList<Student> students=fileManagement.deserealiseObjectCollectionFromJson(contenidoJson,Student.class);
    String Path="src/co/edu/uptc/persistence/Cursos.json";
    String content=fileManagement.readJsonFile(Path);
    ArrayList<Course> cursos=fileManagement.deserealiseObjectCollectionFromJson2(content,Course.class);

    Student estudiante=new Student();
    for(Student s:students) {
        if(s.getId().equals(id))    {
            estudiante=s;
            List<Course> cursosEstudiante=estudiante.getCourses();
            CourseController courseController=CourseController.getInstance();

            courseController.addCourse(courseSelect.getName(),courseSelect.getCode(),courseSelect.getCredits());

            cursosEstudiante.add(courseController.getCourse());

            for(Course c:cursos)    {
                if(c.getCode().equals(courseSelect.getCode()))  {
                    List<Student> studentsCourse=c.getStudents();
                    StudentController studentController=StudentController.getInstance();

                    studentController.addStudent(estudiante.getFirstName(),estudiante.getLastName(), estudiante.getEmail(), estudiante.getId());
                    studentsCourse.add(studentController.getStudent());
                }
            }
            String endContent=fileManagement.serializeObjectCollectionToJson2(cursos);
            fileManagement.saveData(Path,endContent);
            String end=fileManagement.serializeObjectCollectionToJson2(students);
            fileManagement.saveData(path,end);


        }
    }



}else if(e.getSource()==buttonCancel)   {
    this.setVisible(false);
}

    }
}
