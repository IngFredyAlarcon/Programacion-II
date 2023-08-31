package co.edu.uptc.presentacion;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.*;

import co.edu.uptc.control.PersonControl;

public class FormMain {
    private JMenuBar menuBar;
    private JMenu menuPerson;
    private JMenu menuEmpresa;
    private JFrame frameMainMenu;
    private JMenuItem submenuItemCreatePersona;
    private JMenuItem submenuItemListPersona;
    private JMenuItem submenuItemCreateEmpresa;
    private JMenuItem submenuItemListEmpresa;
    private FormPerson fp;

    public void drawFormMainMenu() {
        frameMainMenu = new JFrame("Main Menu");
        menuBar = new JMenuBar();
        menuPerson = new JMenu("Person");
        menuEmpresa = new JMenu("Empresa");
        submenuItemCreatePersona = new JMenuItem("Create Person");
        submenuItemListPersona = new JMenuItem("List Persons");
        submenuItemCreateEmpresa = new JMenuItem("Create Empresa");
        submenuItemListEmpresa = new JMenuItem("List Empresas");
        menuPerson.add(submenuItemCreatePersona);
        menuPerson.add(submenuItemListPersona);
        menuEmpresa.add(submenuItemCreateEmpresa);
        menuEmpresa.add(submenuItemListEmpresa);
        menuBar.add(menuPerson);
        menuBar.add(menuEmpresa);
        frameMainMenu.setJMenuBar(menuBar);
        frameMainMenu.setSize(400, 400);
        frameMainMenu.setLayout(null);
        frameMainMenu.setVisible(true);
    }

    public void openFormPerson() {

    }

}
