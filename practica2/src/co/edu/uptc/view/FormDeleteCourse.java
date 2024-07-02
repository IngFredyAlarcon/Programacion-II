package co.edu.uptc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import co.edu.uptc.controller.CourseController;
import co.edu.uptc.model.Course;
import co.edu.uptc.util.FileManagement;

public class FormDeleteCourse extends JFrame implements ActionListener{

    private JLabel labelIdCourseDelete;
    private JTextField idCourseDelete;

    private JButton button;
    private JButton cancelButton;

    public FormDeleteCourse() {
        this.initComponents();
    }

    public void initComponents() {
        setSize(350, 250);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        labelIdCourseDelete = new JLabel("Id course to delete:");
        idCourseDelete = new JTextField();
        button = new JButton("Delete");
        cancelButton = new JButton("Cancel");

        labelIdCourseDelete.setBounds(10, 10, 130, 30);
        idCourseDelete.setBounds(120, 10, 200, 30);

        button.setBounds(55, 170, 100, 30);
        cancelButton.setBounds(155, 170, 100, 30);

        setLayout(null);

        this.add(this.labelIdCourseDelete);
        this.add(this.idCourseDelete);
        this.add(this.button);
        this.add(this.cancelButton);

        this.button.addActionListener(this);
        this.cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            FileManagement fileManagement=new FileManagement();
            String id=idCourseDelete.getText();
            String Path="src/co/edu/uptc/persistence/Cursos.json";
            String contenido=fileManagement.readJsonFile(Path);
            ArrayList<Course> cursos=fileManagement.deserealiseObjectCollectionFromJson2(contenido,Course.class);
            boolean isExist=false;
            for (Course course:cursos)  {
                if(id.equals(course.getCode())) {
                    isExist=true;
                }
            }

            if(isExist) {
                Course CourseEncontrado = null;
                for (Course curse : cursos) {
                    if (curse.getCode().equals(id)) {
                        CourseEncontrado = curse;
                        break;
                    }
                }
                if (CourseEncontrado != null) {
                    cursos.remove(CourseEncontrado);
                    String contenidoFinal=fileManagement.serializeObjectCollectionToJson2(cursos);
                    fileManagement.saveData(Path,contenidoFinal);
                }

                CourseController cc = CourseController.getInstance();
                cc.deleteCourse();

                this.setVisible(false);
            }else if(!isExist) {
                JOptionPane.showMessageDialog(this,"Not found");
            }


        }

        if (e.getSource() == cancelButton) {
            this.dispose();
        }
    }
}
