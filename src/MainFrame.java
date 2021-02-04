import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MainFrame extends JFrame{

    public MenuPage menuPage;
    public AddStudentPage addStudentPage;
    public ListStudentPage listStudentPage;

    public MainFrame(){

        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Application");
        setResizable(false);

        menuPage = new MenuPage();
        menuPage.setLocation(0,0);
        add(menuPage);

        addStudentPage = new AddStudentPage();
        addStudentPage.setLocation(0,0);
        add(addStudentPage);

        listStudentPage = new ListStudentPage(this);
        listStudentPage.setLocation(0,0);
        add(listStudentPage);
        showMenuPage();

    }
    public void showMenuPage(){
        menuPage.setVisible(true);
        addStudentPage.setVisible(false);
        listStudentPage.setVisible(false);
    }

    public void showAddStudentPage(){
        menuPage.setVisible(false);
        addStudentPage.setVisible(true);
        listStudentPage.setVisible(false);
    }
    public void showListStudentPage(){
        menuPage.setVisible(false);
        addStudentPage.setVisible(false);
        listStudentPage.setVisible(true);
        listStudentPage.fillArea();
    }
}