package co.edu.uptc.view;

import javax.swing.*;

import co.edu.uptc.controller.CourseController;
import co.edu.uptc.controller.StudentController;
import co.edu.uptc.model.Course;
import co.edu.uptc.model.Student;
import co.edu.uptc.util.FileManagement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FormStudent extends javax.swing.JFrame implements ActionListener {

    private JLabel labelFirstName;// Etiqueta para el nombre del estudiante
    private JLabel labelLastName;// Etiqueta para el apellido del estudiante
    private JLabel labelEmail;// Etiqueta para el correo del estudiante
    private JLabel labelId;// Etiqueta para el id del estudiante
   // private JLabel labelCourse;// Etiqueta para el curso del estudiante

    private JTextField textFieldFirstName;// Campo de texto para el nombre del estudiante
    private JTextField textFieldLastName;// Campo de texto para el apellido del estudiante
    private JTextField textFieldEmail;// Campo de texto para el correo del estudiante
    private JTextField textFieldId;// Campo de texto para el id del estudiante
    //private JComboBox<Course> comboBoxCourses;// ComboBox para los cursos del estudiante

    private JButton buttonSave;// Botón para guardar la información del estudiante
    private JButton buttonCancel;// Botón para cancelar la operación

    public FormStudent() {
        initComponents();
    }

    public FormStudent(boolean isEdit) {
        initComponents();
        StudentController studentController = StudentController.getInstance();
        textFieldFirstName.setText(studentController.getStudent().getFirstName());
        textFieldLastName.setText(studentController.getStudent().getLastName());
        textFieldEmail.setText(studentController.getStudent().getEmail());
        textFieldId.setText(studentController.getStudent().getId());
    }

    private void initComponents() {
        setSize(350, 250);// Establece el tamaño del formulario
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);// Establece la operación por defecto al
        // cerrar el formulario
        labelFirstName = new JLabel("FirstName:");
        labelLastName = new JLabel("LastName:");
        labelEmail = new JLabel("Email:");
        labelId = new JLabel("Id:");


        textFieldFirstName = new JTextField();
        textFieldLastName = new JTextField();
        textFieldEmail = new JTextField();
        textFieldId = new JTextField();



        buttonSave = new JButton("Save");
        buttonCancel = new JButton("Cancel");

        setLayout(null);// Establece el layout del formulario en null

        labelFirstName.setBounds(10, 10, 100, 30);// Establece la posición y tamaño de la etiqueta del nombre
        labelLastName.setBounds(10, 50, 100, 30);// Establece la posición y tamaño de la etiqueta del apellido
        labelEmail.setBounds(10, 90, 100, 30);// Establece la posición y tamaño de la etiqueta del correo
        labelId.setBounds(10, 130, 100, 30);// Establece la posición y tamaño de la etiqueta del id
        //labelCourse.setBounds(10, 170, 100, 30);// Establece la posición y tamaño de la etiqueta del curso

        textFieldFirstName.setBounds(120, 10, 200, 30);// Establece la posición y tamaño del campo de texto del nombre
        textFieldLastName.setBounds(120, 50, 200, 30);// Establece la posición y tamaño del campo de texto del apellido
        textFieldEmail.setBounds(120, 90, 200, 30);// Establece la posición y tamaño del campo de texto del correo
        textFieldId.setBounds(120, 130, 200, 30);// Establece la posición y tamaño del campo de texto del id



        buttonSave.setBounds(60, 210, 100, 30);// Establece la posición y tamaño del botón de guardar
        buttonCancel.setBounds(170, 210, 100, 30);// Establece la posición y tamaño del botón de cancelar



        add(labelFirstName);// Agrega la etiqueta del nombre al formulario
        add(labelLastName);// Agrega la etiqueta del apellido al formulario
        add(labelEmail);// Agrega la etiqueta del correo al formulario
        add(labelId);// Agrega la etiqueta del id al formulario


        add(textFieldFirstName);// Agrega el campo de texto del nombre al formulario
        add(textFieldLastName);// Agrega el campo de texto del apellido al formulario
        add(textFieldEmail);// Agrega el campo de texto del correo al formulario
        add(textFieldId);// Agrega el campo de texto del id al formulario


        add(buttonSave);// Agrega el botón de guardar al formulario
        add(buttonCancel);// Agrega el botón de cancelar al formulario

        buttonSave.addActionListener(this);
        buttonCancel.addActionListener(this);

        setSize(350, 320);// Establece el tamaño del formulario
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    public JLabel getLabelFirstName() {
        return labelFirstName;
    }

    public void setLabelFirstName(JLabel labelFirstName) {
        this.labelFirstName = labelFirstName;
    }

    public JLabel getLabelLastName() {
        return labelLastName;
    }

    public void setLabelLastName(JLabel labelLastName) {
        this.labelLastName = labelLastName;
    }

    public JLabel getLabelEmail() {
        return labelEmail;
    }

    public void setLabelEmail(JLabel labelEmail) {
        this.labelEmail = labelEmail;
    }

    public JLabel getLabelId() {
        return labelId;
    }

    public void setLabelId(JLabel labelId) {
        this.labelId = labelId;
    }

    public JTextField getTextFieldFirstName() {
        return textFieldFirstName;
    }

    public void setTextFieldFirstName(JTextField textFieldFirstName) {
        this.textFieldFirstName = textFieldFirstName;
    }

    public JTextField getTextFieldLastName() {
        return textFieldLastName;
    }

    public void setTextFieldLastName(JTextField textFieldLastName) {
        this.textFieldLastName = textFieldLastName;
    }

    public JTextField getTextFieldEmail() {
        return textFieldEmail;
    }

    public void setTextFieldEmail(JTextField textFieldEmail) {
        this.textFieldEmail = textFieldEmail;
    }

    public JTextField getTextFieldId() {
        return textFieldId;
    }

    public void setTextFieldId(JTextField textFieldId) {
        this.textFieldId = textFieldId;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public void setButtonSave(JButton buttonSave) {
        this.buttonSave = buttonSave;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        FileManagement fileManagement=new FileManagement();
        if (event.getSource() == buttonSave) {

            String first=textFieldFirstName.getText();
            String last=textFieldLastName.getText();
            String email=textFieldEmail.getText();
            String id=textFieldId.getText();

            boolean isNumber=true;

            try {
                Integer.parseInt(id);
            } catch (NumberFormatException exception) {
                isNumber = false;
            }

            if(isNumber)    {
                if(first.isEmpty() || last.isEmpty() || email.isEmpty() || id.isEmpty())    {
                    JOptionPane.showMessageDialog(this,"complete all fields");
                    return;
                }
                StudentController studentController = StudentController.getInstance();
                studentController.saveStudent(textFieldFirstName.getText(), textFieldLastName.getText(), textFieldEmail.getText(), textFieldId.getText());
                this.setVisible(false);

                String path="src/co/edu/uptc/persistence/Estudiantes.json";
                String content=fileManagement.readJsonFile(path);
                ArrayList<Student> students=fileManagement.deserealiseObjectCollectionFromJson(content,Student.class);

                boolean exist=false;
                for (Student student: students) {
                    if(studentController.getStudent().getId().equals(student.getId()))  {
                        JOptionPane.showMessageDialog(this,"A Student already exist");
                        exist=true;
                        return;
                    }
                }
                if(!exist)  {
                    students.add(studentController.getStudent());
                    String contenido=fileManagement.serializeObjectCollectionToJson2(students);
                    fileManagement.saveData(path,contenido);
                }
            }



        } else if (event.getSource() == buttonCancel) {
            this.setVisible(false);
        }
    }
}