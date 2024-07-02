package co.edu.uptc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.uptc.controller.CourseController;

public class FormViewCourse extends JFrame implements ActionListener{
    private JLabel labelName;
    private JLabel labelCode;
    private JLabel labelCredits;

    private JTextField textFieldName;
    private JTextField textFieldCode;
    private JTextField textFieldCredits;

    private JButton buttonReturn;

    public FormViewCourse() {
        initComponents();
    }

    public void initComponents(){
        CourseController cc = new CourseController();
        System.out.println(cc.getCourse().getName());
        labelName = new JLabel("Course Name");
        labelCode = new JLabel("Course Code");
        labelCredits = new JLabel("Course Credits");

        textFieldName = new JTextField();
        textFieldCode = new JTextField();
        textFieldCredits = new JTextField();

        textFieldName.setEditable(false);
        textFieldCode.setEditable(false);
        textFieldCredits.setEditable(false);

        textFieldName.setText(cc.getCourse().getName());

        buttonReturn = new JButton("Return");

        setLayout(null);

        labelName.setBounds(10,10,130,30);
        labelCode.setBounds(10, 50, 100, 30);
        labelCredits.setBounds(10, 90, 100, 30);

        textFieldName.setBounds(120, 10, 200, 30);
        textFieldCode.setBounds(120, 50, 200, 30);
        textFieldCredits.setBounds(120, 90, 200, 30);

        buttonReturn.setBounds(55, 170, 100, 30);

        add(labelName);
        add(labelCode);
        add(labelCredits);

        add(textFieldName);
        add(textFieldCode);
        add(textFieldCredits);

        add(buttonReturn);

        buttonReturn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonReturn){
            this.dispose();
        }
    }
    
}
