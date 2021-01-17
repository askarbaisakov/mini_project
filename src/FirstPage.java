import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;

public class FirstPage extends JPanel {

    public static Connection conn;

    private MainFrame parent;


    private JLabel labelName;
    private JTextField nameTextField;
    private JLabel labelSurname;
    private JTextField surnameTextField;
    private JLabel labelAge;
    private JTextField AgeTextField;
    private JButton add;
    private JButton back;

    private String header[] = {"Name", "Surname", "Age"};
    private JTable table;
    private JScrollPane scrollPane;

    ArrayList<Students> Student = new ArrayList<Students>();
    private int sizeOfStudents = 0;


    public FirstPage(MainFrame parent){
        this.parent = parent;

        connectToDb();

        setSize(600, 600);
        setLayout(null);

        labelName = new JLabel("NAME: ");
        labelName.setSize(300,30);
        labelName.setLocation(50,50);
        add(labelName);

        nameTextField = new JTextField();
        nameTextField.setSize(300,30);
        nameTextField.setLocation(150,50);
        add(nameTextField);

        labelSurname = new JLabel("SURNAME: ");
        labelSurname.setSize(300,30);
        labelSurname.setLocation(50,100);
        add(labelSurname);

        surnameTextField = new JTextField();
        surnameTextField.setSize(300,30);
        surnameTextField.setLocation(150,100);
        add(surnameTextField);

        labelAge = new JLabel("AGE: ");
        labelAge.setSize(300,30);
        labelAge.setLocation(50,150);
        add(labelAge);

        AgeTextField = new JTextField();
        AgeTextField.setSize(300,30);
        AgeTextField.setLocation(150,150);
        add(AgeTextField);

        add = new JButton("ADD");
        add.setSize(120,30);
        add.setLocation(40,300);
        add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Students students = new Students(sizeOfStudents, nameTextField.getText(), surnameTextField.getText(), Integer.parseInt(AgeTextField.getText()));
                Student.add((students));
                addStudents(students);
                System.out.println(Student.get(sizeOfStudents));
                sizeOfStudents++;
            }
        });

        back = new JButton("BACK");
        back.setSize(120, 30);
        back.setLocation(270,300);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getFirstPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });





    }

    public ArrayList<Students> getStudents() {return Student;}

    public int getSizeOfStudents() {return sizeOfStudents;}

    public static void connectToDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project?useUnicode=true&serverTimeZone=UTC", "root","");
            System.out.println("Connected");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addStudents(Students i){
        try {
            PreparedStatement st = conn.prepareStatement("insert into students (id, name, surname, age) values(?,?,?,?)");
            st.setInt(1, i.getId());
            st.setString(2, i.getName());
            st.setString(3,i.getSurname());
            st.setInt(4, i.getAge());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
