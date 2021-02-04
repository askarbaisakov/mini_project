import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class MenuPage extends Container{
    private JButton addSt, listSt, exit;
    public MenuPage(){

        setSize(600,600);
        setLayout(null);

        addSt = new JButton("ADD STUDENT");
        addSt.setSize(200,30);
        addSt.setLocation(200,50);
        add(addSt);

        addSt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Main.frame.showAddStudentPage();
            }
        });

        listSt = new JButton("LIST STUDENT");
        listSt.setSize(200,30);
        listSt.setLocation(200,150);
        listSt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Students s = new Students();
                PackageData pd = new PackageData("list",s);
                Main.sendPackage(pd);
                Main.frame.showListStudentPage();
            }
        });
        add(listSt);

        exit = new JButton("exit");
        exit.setSize(200,30);
        exit.setLocation(200,250);
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        add(exit);
    }
}