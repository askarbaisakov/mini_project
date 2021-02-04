import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class AddStudentPage extends Container{
    private JButton backButton, addButton;
    private JTextField nameField, surnameField, ageField;
    private JLabel nameLabel, surnameLabel, messageLabel, ageLabel;
    private int id =0;
    public AddStudentPage(){
        setSize(600,600);
        setLayout(null);
        nameLabel = new JLabel("NAME : ");
        nameLabel.setSize(100,30);
        nameLabel.setLocation(150,100);
        add(nameLabel);

        surnameLabel = new JLabel("SURNAME : ");
        surnameLabel.setSize(100,30);
        surnameLabel.setLocation(150,150);
        add(surnameLabel);

        ageLabel = new JLabel("AGE :");
        ageLabel.setSize(100, 30);
        ageLabel.setLocation(150,200);
        add(ageLabel);

        nameField = new JTextField();
        nameField.setSize(200,30);
        nameField.setLocation(270,100);
        add(nameField);

        surnameField = new JTextField();
        surnameField.setSize(200,30);
        surnameField.setLocation(270,150);
        add(surnameField);

        ageField = new JTextField();
        ageField.setSize(200,30);
        ageField.setLocation(270,200);
        add(ageField);

        messageLabel = new JLabel("Student added successfully");
        messageLabel.setSize(400,30);
        messageLabel.setLocation(200,30);
        messageLabel.setVisible(false);
        add(messageLabel);



        backButton = new JButton("BACK");
        backButton.setSize(100,30);
        backButton.setLocation(320,400);
        backButton.setBackground(Color.WHITE);
        add(backButton);

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                refresh();
                Main.frame.showMenuPage();
            }
        });

        addButton = new JButton("ADD");
        addButton.setSize(100,30);
        addButton.setLocation(190,400);
        add(addButton);

        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = nameField.getText();
                String surname = surnameField.getText();
                int age = Integer.parseInt(ageField.getText());
                Students st = new Students(id, name, surname, age);
                id++;

                PackageData pd = new PackageData("add",st);
                Main.sendPackage(pd);
                refresh();
                messageLabel.setVisible(true);
            }
        });
    }

    private void refresh(){
        messageLabel.setVisible(false);
        nameField.setText("");
        surnameField.setText("");
        ageField.setText("");
    }
}