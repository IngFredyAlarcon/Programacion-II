package co.edu.uptc.view;

import co.edu.uptc.controller.CourseController;
import co.edu.uptc.model.Course;
import co.edu.uptc.model.Student;
import co.edu.uptc.util.FileManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormDeleteStudent extends JFrame implements ActionListener {

    private JLabel labelIdStudentDelete;
    private JTextField idStudentDelete;

    private JButton button;
    private JButton cancelButton;

    public FormDeleteStudent() {
        this.initComponents();
    }

    public void initComponents() {
        setSize(350, 250);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        labelIdStudentDelete = new JLabel("Id Student to delete:");
        idStudentDelete = new JTextField();
        button = new JButton("Delete");
        cancelButton = new JButton("Cancel");

        labelIdStudentDelete.setBounds(10, 10, 130, 30);
        idStudentDelete.setBounds(120, 10, 200, 30);

        button.setBounds(55, 170, 100, 30);
        cancelButton.setBounds(155, 170, 100, 30);

        setLayout(null);

        this.add(this.labelIdStudentDelete);
        this.add(this.idStudentDelete);
        this.add(this.button);
        this.add(this.cancelButton);

        this.button.addActionListener(this);
        this.cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            FileManagement fileManagement=new FileManagement();
            String id=idStudentDelete.getText();


            String Path="src/co/edu/uptc/persistence/Estudiantes.json";
            String contenido=fileManagement.readJsonFile(Path);
            ArrayList<Student> estudiantes=fileManagement.deserealiseObjectCollectionFromJson(contenido,Student.class);
boolean exist=false;
            for(Student esti:estudiantes)   {
                if(esti.getId().equals(id)) {
                    exist=true;
                }
            }

            if(exist)   {
                Student estudianteEncontrado = null;
                for (Student student : estudiantes) {
                    if (student.getId().equals(id)) {
                        estudianteEncontrado = student;
                        break;
                    }
                }
                if (estudianteEncontrado != null) {
                    estudiantes.remove(estudianteEncontrado);
                    String contenidoFinal=fileManagement.serializeObjectCollectionToJson2(estudiantes);
                    fileManagement.saveData(Path,contenidoFinal);
                }

                CourseController cc = CourseController.getInstance();
                cc.deleteCourse();

                this.setVisible(false);
            }else if(!exist) {
                JOptionPane.showMessageDialog(this,"Not found");
            }


        }

        if (e.getSource() == cancelButton) {
            this.dispose();
        }
    }
}


