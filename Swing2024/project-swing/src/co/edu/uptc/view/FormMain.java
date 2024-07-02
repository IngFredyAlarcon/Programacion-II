package co.edu.uptc.view;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import co.edu.uptc.view.*;

public class FormMain extends JFrame implements ActionListener{
    private JMenuBar menuBar;
    private JMenu studentsMenu, coursesMenu, resportsMenu;
    private JMenuItem newStudentMenuItem, viewStudentMenuItem;
    private JMenuItem newCourseMenuItem, viewCourseMenuItem;

    public FormMain(){
        initComponents();
    }

    public void initComponents(){
        menuBar = new JMenuBar();
        studentsMenu = new JMenu("Students");
        coursesMenu = new JMenu("Courses");
        resportsMenu = new JMenu("Reports");

        newStudentMenuItem = new JMenuItem("New Student");
        viewStudentMenuItem = new JMenuItem("View Students");

        newCourseMenuItem = new JMenuItem("New Course");
        viewCourseMenuItem = new JMenuItem("View Courses");

        newStudentMenuItem.addActionListener(this);
        viewStudentMenuItem.addActionListener(this);
        newCourseMenuItem.addActionListener(this);
        viewCourseMenuItem.addActionListener(this);

        studentsMenu.add(newStudentMenuItem);
        studentsMenu.add(viewStudentMenuItem);

        coursesMenu.add(newCourseMenuItem);
        coursesMenu.add(viewCourseMenuItem);

        menuBar.add(studentsMenu);
        menuBar.add(coursesMenu);
        menuBar.add(resportsMenu);

        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newStudentMenuItem){
            System.out.println("11");
            FormStudent formStudent = new FormStudent();
            formStudent.setVisible(true);
        }
        if(e.getSource() == newCourseMenuItem){
            FormCourse formCourse = new FormCourse();
            formCourse.setVisible(true);
        }

        if(e.getSource() == viewCourseMenuItem){
            FormViewCourse formViewCourse = new FormViewCourse();
            formViewCourse.setVisible(true);
        }
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getStudentsMenu() {
        return studentsMenu;
    }

    public void setStudentsMenu(JMenu studentsMenu) {
        this.studentsMenu = studentsMenu;
    }

    public JMenu getCoursesMenu() {
        return coursesMenu;
    }

    public void setCoursesMenu(JMenu coursesMenu) {
        this.coursesMenu = coursesMenu;
    }

    public JMenu getResportsMenu() {
        return resportsMenu;
    }

    public void setResportsMenu(JMenu resportsMenu) {
        this.resportsMenu = resportsMenu;
    }

    public JMenuItem getNewStudentMenuItem() {
        return newStudentMenuItem;
    }

    public void setNewStudentMenuItem(JMenuItem newStudentMenuItem) {
        this.newStudentMenuItem = newStudentMenuItem;
    }

    public JMenuItem getViewStudentMenuItem() {
        return viewStudentMenuItem;
    }

    public void setViewStudentMenuItem(JMenuItem viewStudentMenuItem) {
        this.viewStudentMenuItem = viewStudentMenuItem;
    }

    public JMenuItem getNewCourseMenuItem() {
        return newCourseMenuItem;
    }

    public void setNewCourseMenuItem(JMenuItem newCourseMenuItem) {
        this.newCourseMenuItem = newCourseMenuItem;
    }

    public JMenuItem getViewCourseMenuItem() {
        return viewCourseMenuItem;
    }

    public void setViewCourseMenuItem(JMenuItem viewCourseMenuItem) {
        this.viewCourseMenuItem = viewCourseMenuItem;
    }
}
