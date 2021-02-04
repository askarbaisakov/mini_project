import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

public class Server{
    private static Connection connection;

    public static void disconnect(){
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project?useUnicode=true&serverTimeZone=UTC", "root","");
        }catch (Exception e) {
            e.printStackTrace();
        }

        try{
            ServerSocket serverSocket = new ServerSocket(1997);

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ServerThreads st = new ServerThreads(socket);
                st.start();

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Students st){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students (id,name,surname,age) VALUES (?,?,?,?)");
            statement.setInt(1,st.getId());
            statement.setString(2,st.getName());
            statement.setString(3,st.getSurname());
            statement.setInt(4,st.getAge());
            statement.executeUpdate();
            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Students> getAllStudents(){
        ArrayList<Students> list = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                int age = result.getInt("age");
                list.add(new Students(id,name,surname,age));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}