import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MainMenu extends JPanel {

    private MainFrame parent;



    private JButton firstPageButton;
    private JButton secondPageButton;
    private JButton exitButton;

    public MainMenu(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);



        firstPageButton = new JButton("ADD STUDENT");
        firstPageButton.setSize(300,30);
        firstPageButton.setLocation(100, 60);
        add(firstPageButton);
        firstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMainMenuPage().setVisible(false);
                parent.getFirstPage().setVisible(true);
            }
        });

        secondPageButton = new JButton("LIST STUDENT");
        secondPageButton.setSize(300,30);
        secondPageButton.setLocation(100,120);
        add(secondPageButton);
        secondPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getSecondPage().generateTable(parent.getFirstPage().getStudents(), parent.getFirstPage().getSizeOfStudents());
                parent.getMainMenuPage().setVisible(false);
                parent.getSecondPage().setVisible(true);
            }
        });

        exitButton = new JButton("EXIT");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,180);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }






}
