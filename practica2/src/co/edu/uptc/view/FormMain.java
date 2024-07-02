package co.edu.uptc.view;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FormMain extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu studentsMenu, coursesMenu, resportsMenu;
    private JMenuItem newStudentMenuItem, viewStudentMenuItem, editCourseMenuItem, enrollCourse,deleteStudentMenuItem;
    private JMenuItem newCourseMenuItem, viewCourseMenuItem, editStudentMenuItem, deleteCourseMenuItem;

    public FormMain() {
        initComponents();
    }

    public void initComponents() {
        menuBar = new JMenuBar();
        studentsMenu = new JMenu("Students");
        coursesMenu = new JMenu("Courses");
        resportsMenu = new JMenu("Reports");

        newStudentMenuItem = new JMenuItem("New Student");
        viewStudentMenuItem = new JMenuItem("View Students");
        editCourseMenuItem = new JMenuItem("Edit Course");
        deleteCourseMenuItem = new JMenuItem("Delete Course");

        newCourseMenuItem = new JMenuItem("New Course");
        viewCourseMenuItem = new JMenuItem("View Courses");
        editStudentMenuItem = new JMenuItem("Edit Student");
        enrollCourse=new JMenuItem("Enroll in course");
        deleteStudentMenuItem=new JMenuItem("Delete Student");



        newStudentMenuItem.addActionListener(this);
        viewStudentMenuItem.addActionListener(this);
        editStudentMenuItem.addActionListener(this);
        enrollCourse.addActionListener(this);
        deleteCourseMenuItem.addActionListener(this);
        deleteStudentMenuItem.addActionListener(this);

        newCourseMenuItem.addActionListener(this);
        viewCourseMenuItem.addActionListener(this);
        editCourseMenuItem.addActionListener(this);


        studentsMenu.add(newStudentMenuItem);
        studentsMenu.add(viewStudentMenuItem);
        studentsMenu.add(editStudentMenuItem);
        studentsMenu.add(enrollCourse);
        studentsMenu.add(deleteStudentMenuItem);

        coursesMenu.add(newCourseMenuItem);
        coursesMenu.add(viewCourseMenuItem);
        coursesMenu.add(editCourseMenuItem);
        coursesMenu.add(deleteCourseMenuItem);

        menuBar.add(studentsMenu);
        menuBar.add(coursesMenu);
        menuBar.add(resportsMenu);

        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newStudentMenuItem) {
            FormStudent formStudent = new FormStudent();
            formStudent.setVisible(true);
        }
        if (e.getSource() == newCourseMenuItem) {
            FormCourse formCourse = new FormCourse();
            formCourse.setVisible(true);
        }
        if (e.getSource() == editStudentMenuItem) {
           FormEditStudent formEditStudent=new FormEditStudent();
           formEditStudent.setVisible(true);
        }

        if (e.getSource() == viewStudentMenuItem) {
            FormViewStudent formViewStudent = new FormViewStudent();
            formViewStudent.setVisible(true);
        }

        if(e.getSource() == enrollCourse)   {
           FormStudentEnrollCourse formStudentEnroll=new FormStudentEnrollCourse();
           formStudentEnroll.setVisible(true);
        }
        if(e.getSource()==deleteStudentMenuItem)    {
            FormDeleteStudent formDeleteStudent=new FormDeleteStudent();
            formDeleteStudent.setVisible(true);
        }


        if (e.getSource() == viewCourseMenuItem) {
            FormViewCourse formViewCourse = new FormViewCourse();
            formViewCourse.setVisible(true);
        }
        if (e.getSource() == editCourseMenuItem) {
            FormEditCourse formEditCourse = new FormEditCourse();
            formEditCourse.setVisible(true);
        }
        if (e.getSource() == deleteCourseMenuItem) {
            FormDeleteCourse formDeleteCourse = new FormDeleteCourse();
            formDeleteCourse.setVisible(true);
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