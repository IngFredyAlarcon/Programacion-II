package co.edu.uptc.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;//Importa la clase ActionListener para el manejo de eventos

import co.edu.uptc.controller.CourseController;

public class FormCourse extends javax.swing.JFrame implements ActionListener{//Clase que representa el formulario de un curso hereda de JFrame e implementa la interfaz ActionListener para el manejo de eventos

    private JLabel labelName;//Etiqueta para el nombre del curso
    private JLabel labelCode;//Etiqueta para el código del curso
    private JLabel labelCredits;//Etiqueta para los créditos del curso

    private JTextField textFieldName;//Campo de texto para el nombre del curso
    private JTextField textFieldCode;//Campo de texto para el código del curso
    private JTextField textFieldCredits;//Campo de texto para los créditos del curso

    private JButton buttonSave;//Botón para la acción de guardar un curso
    private JButton buttonCancel;//Botón para la acción de candelar

    public FormCourse() {
        initComponents();
    }

    public void initComponents(){
        labelName = new JLabel("Course Name");
        labelCode = new JLabel("Course Code");
        labelCredits = new JLabel("Course Credits");

        textFieldName = new JTextField();
        textFieldCode = new JTextField();
        textFieldCredits = new JTextField();

        buttonSave = new JButton("Save");
        buttonCancel = new JButton("Cancel");

        setLayout(null);//Establece el layout del formulario en null

        labelName.setBounds(10,10,130,30);
        labelCode.setBounds(10, 50, 100, 30);//Establece la posición y tamaño de la etiqueta código
        labelCredits.setBounds(10, 90, 100, 30);//Establece la posición y tamaño de la etiqueta créditos

        textFieldName.setBounds(120, 10, 200, 30);//Establece la posición y tamaño del campo de texto del nombre
        textFieldCode.setBounds(120, 50, 200, 30);//Establece la posición y tamaño del campo de texto del código
        textFieldCredits.setBounds(120, 90, 200, 30);//Establece la posición y tamaño del campo de texto de los créditos del curso

        buttonSave.setBounds(55, 170, 100, 30);//Establece la posición y tamaño del botón de guardar
        buttonCancel.setBounds(165, 170, 100, 30);//Establece la posición y tamaño del botón de cancelar

        add(labelName);
        add(labelCode);
        add(labelCredits);

        add(textFieldName);
        add(textFieldCode);
        add(textFieldCredits);

        add(buttonSave);
        add(buttonCancel);

        buttonSave.addActionListener(this);//Añade un evento al botón de guardar
        buttonCancel.addActionListener(this);//Añade un evento al botón de cancelar
        
        setSize(350, 250);//Establece el tamaño del formulario
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//Establece la operación por defecto al cerrar el formulario
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
    
    public void actionPerformed(ActionEvent e) {//Método que se ejecuta al realizar una acción
        if(e.getSource() == buttonSave){//Si el evento es generado por el botón de guardar
            CourseController courseController = new CourseController();
            courseController.saveCourse(textFieldName.getText(), textFieldCode.getText(), Integer.parseInt(textFieldCredits.getText()));
            this.setVisible(false);
            System.out.println(courseController.getCourse());//Imprime el curso guardado en consola
        }
        else{//Si el evento es generado por el botón de cancelar
            if(e.getSource() == buttonCancel){
                System.exit(0);
            }
        }
    }

}
