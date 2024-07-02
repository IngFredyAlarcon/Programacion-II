package co.edu.uptc.view;

import co.edu.uptc.model.Course;
import co.edu.uptc.model.Student;
import co.edu.uptc.util.FileManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormEditStudent extends JFrame implements ActionListener{
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

    private JButton buttonSave;
    private JButton buttonCancel;

    public FormEditStudent() {
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


        textFieldFirstName.setEditable(true);
        textFieldLastName.setEditable(true);
        textFieldEmail.setEditable(true);
        textFieldId.setEditable(true);

        buttonSave = new JButton("Save");
        buttonCancel = new JButton("Cancel");

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


        buttonSave.setBounds(55, 250, 100, 30);// Establece la posición y tamaño del botón de guardar
        buttonCancel.setBounds(165, 250, 100, 30);


        String Path="src/co/edu/uptc/persistence/Estudiantes.json";
        String ContenidoStudents=fileManagement.readJsonFile(Path);
        ArrayList<Student> students=fileManagement.deserealiseObjectCollectionFromJson(ContenidoStudents,Student.class);

        for(Student student:students)   {
            comoboxStudent.addItem(new Student(student.getFirstName(),student.getLastName(),student.getEmail(),student.getId()));
        }

        comoboxStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student studentSelect=(Student) comoboxStudent.getSelectedItem();
                textFieldFirstName.setText(studentSelect.getFirstName());
                textFieldLastName.setText(studentSelect.getLastName());
                textFieldEmail.setText(studentSelect.getEmail());
                textFieldId.setText(String.valueOf(studentSelect.getId()));
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

        add(buttonSave);
        add(buttonCancel);

        this.buttonSave.addActionListener(this);// Añade un evento al botón de guardar
        this.buttonCancel.addActionListener(this);


        setSize(350, 350);// Establece el tamaño del formulario
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonSave)   {
            FileManagement fileManagement=new FileManagement();
            Student studentSelect=(Student) comoboxStudent.getSelectedItem();
            studentSelect.setFirstName(textFieldFirstName.getText());
            studentSelect.setLastName(textFieldLastName.getText());
            studentSelect.setEmail(textFieldEmail.getText());
            boolean isNumber=true;
            try {
                studentSelect.setId(String.valueOf(Integer.parseInt(textFieldId.getText())));
            }catch(NumberFormatException exception) {
                isNumber=false;
            }


            String first=textFieldFirstName.getText();
            String last=textFieldLastName.getText();
            String email=textFieldEmail.getText();
            String id=textFieldId.getText();

            String path="src/co/edu/uptc/persistence/Estudiantes.json";

            if(isNumber){
                if(first.isEmpty() || last.isEmpty() || email.isEmpty() || id.isEmpty())    {
                    JOptionPane.showMessageDialog(this,"complete all fields");
                    return;
                }
                String contenido=fileManagement.readJsonFile(path);
                ArrayList<Student> estudiantes=fileManagement.deserealiseObjectCollectionFromJson(contenido,Student.class);
                boolean exist=false;
                for(Student estudiante:estudiantes) {
                    if (id.equals(estudiante.getId())) {
                        JOptionPane.showMessageDialog(this, "A Student code already exist");
                        exist = true;
                        return;
                    }
                }
                if(!exist)   {
                    ArrayList<Student> studentsList=new ArrayList<>();
                    for (int i=0;i<comoboxStudent.getItemCount();i++) {
                        studentsList.add(comoboxStudent.getItemAt(i));
                    }
                }
                String content=fileManagement.serializeObjectCollectionToJson2(estudiantes);
                fileManagement.saveData(path,content);

            }else   {
                JOptionPane.showMessageDialog(this,"credits only number");
            }




        }else if(e.getSource()==buttonCancel)   {
            this.setVisible(false);
        }
    }

}
