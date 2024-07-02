package co.edu.uptc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import co.edu.uptc.controller.StudentController;
import co.edu.uptc.model.Course;
import co.edu.uptc.model.Student;
import co.edu.uptc.util.FileManagement;

public class FormViewStudent extends JFrame implements ActionListener {

    private JLabel labelElection;
    private JLabel labelFirstName;// Etiqueta para el nombre del estudiante
    private JLabel labelLastName;// Etiqueta para el apellido del estudiante
    private JLabel labelEmail;// Etiqueta para el correo del estudiante
    private JLabel labelId;// Etiqueta para el id del estudiante

    private JComboBox<Student> comoboxStudent;

    private JTextField textFieldFirstName;// Campo de texto para el nombre del estudiante
    private JTextField textFieldLastName;// Campo de texto para el apellido del estudiante
    private JTextField textFieldEmail;// Campo de texto para el correo del estudiante
    private JTextField textFieldId;// Campo de texto para el id del estudiante

    private JLabel labelCoursesStudents;
    private JComboBox<Course> coursesStudent;

    private JButton buttonReturn;// Botón para cancelar la operación

    public FormViewStudent() {
        this.initComponents();
    }

    private void initComponents() {

        FileManagement fileManagement=new FileManagement();

        labelElection=new JLabel("Select Student");
        labelFirstName = new JLabel("FirstName:");
        labelLastName = new JLabel("LastName:");
        labelEmail = new JLabel("Email:");
        labelId = new JLabel("Id:");


        comoboxStudent =new JComboBox<>();

        textFieldFirstName = new JTextField();
        textFieldLastName = new JTextField();
        textFieldEmail = new JTextField();
        textFieldId = new JTextField();


        textFieldFirstName.setEditable(false);
        textFieldLastName.setEditable(false);
        textFieldEmail.setEditable(false);
        textFieldId.setEditable(false);

        labelCoursesStudents=new JLabel("Student Courses");
        coursesStudent=new JComboBox<>();

        buttonReturn = new JButton("Return");

        this.setLayout(null);
        labelElection.setBounds(10,10,130,30);
        labelFirstName.setBounds(10, 60, 100, 30);
        labelLastName.setBounds(10, 100, 100, 30);
        labelEmail.setBounds(10, 140, 100, 30);
        labelId.setBounds(10, 180, 100, 30);

        comoboxStudent.setBounds(120,10,200,30);

        textFieldFirstName.setBounds(120, 60, 200, 30);
        textFieldLastName.setBounds(120, 100, 200, 30);
        textFieldEmail.setBounds(120, 140, 200, 30);
        textFieldId.setBounds(120, 180, 200, 30);

        labelCoursesStudents.setBounds(10,220,100,30);
        coursesStudent.setBounds(120,220,100,30);
        buttonReturn.setBounds(120, 300, 100, 30);


        String Path="src/co/edu/uptc/persistence/Estudiantes.json";
        String ContenidoStudents=fileManagement.readJsonFile(Path);
        ArrayList<Student> students=fileManagement.deserealiseObjectCollectionFromJson(ContenidoStudents,Student.class);

        for(Student student:students)   {
            comoboxStudent.addItem(student);
        }


        comoboxStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student studentSelect=(Student) comoboxStudent.getSelectedItem();
                textFieldFirstName.setText(studentSelect.getFirstName());
                textFieldLastName.setText(studentSelect.getLastName());
                textFieldEmail.setText(studentSelect.getEmail());
                textFieldId.setText(String.valueOf(studentSelect.getId()));
                coursesStudent.removeAllItems();
                List<Course> cursos=studentSelect.getCourses();

                for(Course curso: cursos)   {

                    coursesStudent.addItem(curso);
                }

            }
        });




        this.add(labelElection);
        this.add(labelFirstName);
        this.add(labelLastName);
        this.add(labelEmail);
        this.add(labelId);

        this.add(comoboxStudent);

        this.add(textFieldFirstName);
        this.add(textFieldLastName);
        this.add(textFieldEmail);
        this.add(textFieldId);

        this.add(labelCoursesStudents);
        this.add(coursesStudent);

        this.add(buttonReturn);

        buttonReturn.addActionListener(this);
        setSize(350, 400);// Establece el tamaño del formulario
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonReturn) {
            this.setVisible(false);
        }
    }
}