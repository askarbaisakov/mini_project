import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

public class ServerThreads extends Thread{
    private Socket socket;
    public ServerThreads(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            PackageData pd = new PackageData();
            while((pd=(PackageData)inStream.readObject())!=null){
                if(pd.getOperationType().equals("add")){
                    Students st = pd.getStudent();
                    Server.addStudent(st);
                }else if (pd.getOperationType().equals("list")) {
                    ArrayList<Students> db = Server.getAllStudents();
                    PackageData response = new PackageData("list",db);
                    outStream.writeObject(response);

                }else if (pd.getOperationType().equals("exit")) {
                    Server.disconnect();
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}