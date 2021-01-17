import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {

    private String operationType;
    private ArrayList<Students> students;
    private Students student;

    public PackageData(){}

    public PackageData(String operationType, ArrayList<Students> students, Students student) {
        this.operationType = operationType;
        this.students = students;
        this.student = student;
    }

    public String getOperationType() {
        return operationType;
    }

    public ArrayList<Students> getStudents() {
        return students;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = students;
    }

    public Students getStudent(){
        return student;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", students=" + students +
                ", students=" + students +
                '}';
    }
}
