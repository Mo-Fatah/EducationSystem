import java.util.ArrayList;

public class StudentsData {
    private static ArrayList<Student> students = new ArrayList<Student>();
    public static void addStudent(Student stdnt){
        students.add(stdnt);
    }
    public static ArrayList<Student> getStudents(){
        return students;
    }

}
