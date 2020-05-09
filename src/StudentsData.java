import java.util.ArrayList;

public class StudentsData {
    private static ArrayList<Student> students = new ArrayList<Student>();
    public static void addStudent(Student stdnt){
        students.add(stdnt);
    }
    public static ArrayList<Student> getStudents(){
        return students;
    }
    public static boolean verifyPassId(int pass , int id){
        for(Student student : students){
            if(student.getId() == id || student.getPassword() == pass){
                return false;
            }
        }

        return true;
    }

}
