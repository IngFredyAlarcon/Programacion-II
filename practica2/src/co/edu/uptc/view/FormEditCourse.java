package co.edu.uptc.view;

import co.edu.uptc.controller.CourseController;
import co.edu.uptc.model.Course;
import co.edu.uptc.util.FileManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormEditCourse extends JFrame implements ActionListener {
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

    private JButton buttonSave;
    private JButton buttonCancel;

    public FormEditCourse() {
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

        textFieldName.setEditable(true);
        textFieldCode.setEditable(true);
        textFieldCredits.setEditable(true);



        buttonSave = new JButton("Save");
        buttonCancel = new JButton("Cancel");

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

        buttonSave.setBounds(55, 250, 100, 30);// Establece la posición y tamaño del botón de guardar
        buttonCancel.setBounds(165, 250, 100, 30);

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




        add(labelElection);
        add(labelTitle);
        add(labelName);
        add(labelCode);
        add(labelCredits);

        add(comoboxCourses);

        add(textFieldName);
        add(textFieldCode);
        add(textFieldCredits);

        add(buttonSave);
        add(buttonCancel);

        buttonSave.addActionListener(this);// Añade un evento al botón de guardar
        buttonCancel.addActionListener(this);

        setSize(350, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public FileManagement getFileManagement() {
        return fileManagement;
    }

    public void setFileManagement(FileManagement fileManagement) {
        this.fileManagement = fileManagement;
    }

    public JLabel getLabelElection() {
        return labelElection;
    }

    public void setLabelElection(JLabel labelElection) {
        this.labelElection = labelElection;
    }

    public JLabel getLabelTitle() {
        return labelTitle;
    }

    public void setLabelTitle(JLabel labelTitle) {
        this.labelTitle = labelTitle;
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

    public JComboBox<Course> getComoboxCourses() {
        return comoboxCourses;
    }

    public void setComoboxCourses(JComboBox<Course> comoboxCourses) {
        this.comoboxCourses = comoboxCourses;
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
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==buttonSave)    {


           Course courseSelect= (Course) comoboxCourses.getSelectedItem();
           courseSelect.setName(textFieldName.getText());
           courseSelect.setCode(textFieldCode.getText());
           boolean isNumber=true;
           try  {
               courseSelect.setCredits(Integer.parseInt(textFieldCredits.getText()));
           }catch (NumberFormatException exception) {
               isNumber = false;
           }


           String name = courseSelect.getName();
           String code = courseSelect.getCode();
           String credits = String.valueOf(courseSelect.getCredits());



           if (isNumber) {
               if (name.isEmpty() || code.isEmpty() || credits.isEmpty()) {
                   JOptionPane.showMessageDialog(this, "complete all fields");
                   return;
               }

               String Path = "src/co/edu/uptc/persistence/Cursos.json";
               String content=fileManagement.readJsonFile(Path);
               ArrayList<Course> cursos= fileManagement.deserealiseObjectCollectionFromJson2(content,Course.class);
               boolean exist=false;
               for(Course curso:cursos) {
                   if (code.equals(curso.getCode())) {
                       JOptionPane.showMessageDialog(this, "A course code already exist");
                       exist = true;
                       return;
                   }
               }
               if(!exist)   {
                   ArrayList<Course> cursos2 = new ArrayList<>();
                   for (int i = 0; i < comoboxCourses.getItemCount(); i++) {
                       cursos2.add(comoboxCourses.getItemAt(i));
                   }
               }



               String contentEnd = fileManagement.serializeObjectCollectionToJson2(cursos);
               fileManagement.saveData(Path, contentEnd);
           }else   {
               JOptionPane.showMessageDialog(this,"credits only number");
           }

       }else if(e.getSource()==buttonCancel)    {
           this.setVisible(false);
       }
    }
}
