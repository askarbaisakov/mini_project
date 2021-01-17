import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SecondPage extends JPanel {

    public static Connection conn;

    private MainFrame parent;

    private JLabel label;
    private JButton back;

    private String header[] = {"ID", "Name", "Surname", "Age"};
    private JTable table;
    private JScrollPane scrollPane;

    public SecondPage(MainFrame parent){

        this.parent = parent;
        setSize(600,600);
        setLayout(null);

        connectToDb();

        label = new JLabel("List students");
        label.setSize(300,30);
        label.setLocation(100, 50);
        add(label);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);
        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,200);
        scrollPane.setLocation(100,100);
        add(scrollPane);

        back = new JButton("Back");
        back.setSize(300,30);
        back.setLocation(100,350);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getSecondPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }

    public static void connectToDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project?useUnicode=true&serverTimeZone=UTC", "root","");
            System.out.println("Connected");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Students> getAllStudents(){
        ArrayList<Students> students = new ArrayList<>();
        try{
            PreparedStatement st = conn.prepareStatement("select * from students");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = (int) rs.getLong("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = (int) rs.getLong("age");
                students.add(new Students(id,name,surname, age));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return students;
    }

    public void generateTable(ArrayList<Students> students, int stop){



        students = getAllStudents();

        Object data[][] = new Object[students.size()][4];

        for (int i = 0; i < students.size(); i++){
            data[i][0] = students.get(i).getId();
            data[i][1] = students.get(i).getName();
            data[i][2] = students.get(i).getSurname();
            data[i][3] = students.get(i).getAge();
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }







}
