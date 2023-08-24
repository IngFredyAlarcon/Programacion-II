package co.edu.uptc.presentacion;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.uptc.control.PersonControl;

//import javax.swing.event.*;
import java.awt.event.*;

public class FormPerson {
    public static void main(String[] args) {
        JFrame framePerson = new JFrame("Form Person");
        JLabel labelNamePerson = new JLabel("enter name");
        labelNamePerson.setBounds(10, 10, 100, 30);
        JTextField textNamePerson = new JTextField();
        textNamePerson.setBounds(150, 10, 100, 30);
        JLabel labelAgePerson = new JLabel("enter age");
        labelAgePerson.setBounds(10, 60, 100, 30);
        JTextField textAgePerson = new JTextField();
        textAgePerson.setBounds(150, 60, 100, 30);
        JButton buttonAddPerson = new JButton("Add");
        buttonAddPerson.setBounds(50, 100, 95, 30);
        JLabel responseAddPerson = new JLabel("");
        responseAddPerson.setBounds(50, 130, 100, 30);
        responseAddPerson.setVisible(false);
        framePerson.add(labelNamePerson);
        framePerson.add(labelAgePerson);
        framePerson.add(textNamePerson);
        framePerson.add(textAgePerson);
        framePerson.add(buttonAddPerson);
        framePerson.add(responseAddPerson);
        framePerson.setSize(400, 400);
        buttonAddPerson.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        PersonControl pc = new PersonControl();
                        boolean aux = false;
                        aux = pc.addPerson(textNamePerson.getText(), Integer.parseInt(textAgePerson.getText()));
                        if (aux) {
                            responseAddPerson.setText("Person add successfull");
                            responseAddPerson.setVisible(true);
                        }
                    }
                });
        framePerson.setLayout(null);
        framePerson.setVisible(true);
    }
}
