
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
public class ListStudentPage extends JPanel{

    private MainFrame parent;

    private JLabel label;
    private JButton back;
    private JTable table;
    private String titles[] = {"id","name","surname","age"};
    private JScrollPane scrollPane;

    public ListStudentPage(MainFrame parent){
        this.parent = parent;
        setSize(600,600);
        setLayout(null);

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

        back = new JButton("BACK");
        back.setSize(200,30);
        back.setLocation(250,450);
        add(back);

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Main.frame.showMenuPage();
            }
        });
    }

    public void fillArea(){
        PackageData response = Main.getPackage();
        ArrayList<Students> students = response.getStudents();
        Object values[][]= new Object[students.size()][4];
        for(int i=0;i<students.size();i++){
            values[i][0] =students.get(i).getId();
            values[i][1] = students.get(i).getName();
            values[i][2] = students.get(i).getSurname();
            values[i][3] = students.get(i).getAge();
        }

        DefaultTableModel model = new DefaultTableModel(values, titles);
        table.setModel(model);
    }
}