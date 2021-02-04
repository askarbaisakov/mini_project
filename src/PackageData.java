import java.io.*;
import java.util.*;
public class PackageData implements Serializable{
    private String operationType;
    private ArrayList<Students> students;
    private Students student;

    public PackageData() {
    }

    public PackageData(String operationType, Students student) {
        this.operationType = operationType;
        this.student = student;
    }
    public PackageData(String operationType, ArrayList<Students> students) {
        this.operationType = operationType;
        this.students = students;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Students getStudent() {
        return student;
    }
    public ArrayList<Students> getStudents() {
        return students;
    }


    public void setBooks(Students student) {
        this.student = student;
    }
}