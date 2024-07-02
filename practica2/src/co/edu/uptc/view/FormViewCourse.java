package co.edu.uptc.view;

import co.edu.uptc.controller.CourseController;
import co.edu.uptc.model.Course;
import co.edu.uptc.model.Student;
import co.edu.uptc.util.FileManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormViewCourse extends JFrame implements ActionListener {
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

    private JLabel labelStudentCourse;
    private JComboBox<Student> comboboxStudents;
    private JButton buttonReturn;

    public FormViewCourse() {
       initComponents();
    }

    public void initComponents()    {
        CourseController cc=CourseController.getInstance();
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

        labelStudentCourse=new JLabel("Students Course");
        comboboxStudents=new JComboBox<>();


        buttonReturn=new JButton("Return");

        setLayout(null);
        labelElection.setBounds(10,10,130,30);
        labelTitle.setBounds(95,60,130,30);
        labelName.setBounds(10,100,130,30);
        labelCode.setBounds(10, 140, 100, 30);//Establece la posición y tamaño de la etiqueta código
        labelCredits.setBounds(10, 180, 100, 30);//Establece la posición y tamaño de la etiqueta créditos

        comoboxCourses.setBounds(120,10,200,30);

        textFieldName.setBounds(120, 100, 200, 30);//Establece la posición y tamaño del campo de texto del nombre
        textFieldCode.setBounds(120, 140, 200, 30);//Establece la posición y tamaño del campo de texto del código
        textFieldCredits.setBounds(120, 180, 200, 30);//Establece la posición y tamaño del campo de texto de los créditos del curso

        labelStudentCourse.setBounds(10,220,100,30);
        comboboxStudents.setBounds(120,220,100,30);
        buttonReturn.setBounds(95, 260, 100, 30);//Establece la posición y tamaño del botón de guardar

        String path="src/co/edu/uptc/persistence/Cursos.json";
        String ContenidoCursos=fileManagement.readJsonFile(path);
        ArrayList<Course> cursos=fileManagement.deserealiseObjectCollectionFromJson2(ContenidoCursos,Course.class);
        for(Course curso:cursos){
            comoboxCourses.addItem(curso);

        }


        comoboxCourses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course courseSelect= (Course) comoboxCourses.getSelectedItem();
                textFieldName.setText(courseSelect.getName());
                textFieldCode.setText(courseSelect.getCode());
                textFieldCredits.setText(String.valueOf(courseSelect.getCredits()));
                comboboxStudents.removeAllItems();
                List<Student> estudiantes=courseSelect.getStudents();

                for(Student s:estudiantes)  {
                    comboboxStudents.addItem(s);
                }

            }
        });


        add(labelElection);
        add(labelTitle);
       add(labelName);
       add(labelCode);
       add(labelCredits);

       add(comoboxCourses);

        add(textFieldName);
        add(textFieldCode);
        add(textFieldCredits);

        add(labelStudentCourse);
        add(comboboxStudents);

       add(buttonReturn);

        buttonReturn.addActionListener(this);
       setSize(350, 350);
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }



    public JLabel getLabelName() {
        return labelName;
    }

    public void setLabelName(JLabel labelName) {
        this.labelName = labelName;
    }

    public JLabel getLabelCode() {
        return labelCode;
    }

    public void setLabelCode(JLabel labelCode) {
        this.labelCode = labelCode;
    }

    public JLabel getLabelCredits() {
        return labelCredits;
    }

    public void setLabelCredits(JLabel labelCredits) {
        this.labelCredits = labelCredits;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public void setTextFieldName(JTextField textFieldName) {
        this.textFieldName = textFieldName;
    }

    public JTextField getTextFieldCode() {
        return textFieldCode;
    }

    public void setTextFieldCode(JTextField textFieldCode) {
        this.textFieldCode = textFieldCode;
    }

    public JTextField getTextFieldCredits() {
        return textFieldCredits;
    }

    public void setTextFieldCredits(JTextField textFieldCredits) {
        this.textFieldCredits = textFieldCredits;
    }

    public JButton getButtonReturn() {
        return buttonReturn;
    }

    public void setButtonReturn(JButton buttonReturn) {
        this.buttonReturn = buttonReturn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== buttonReturn)    {
            this.setVisible(false);
        }
    }

}

