import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String name;
    private String code;
    private ArrayList<Student> students;
    private Doctor doctor;
    private String TA;
    private ArrayList<String> Ass;
    private HashMap<String, Integer> grades;
    public Course(String name , String code ){
        this.name = name;
        this.code = code;
    }
    public void setStaff(Doctor doctor, String TA){
        this.doctor = doctor;
        this.TA = TA;
    }
    public ArrayList<String> courseInfo(){
        ArrayList<String> info = new ArrayList<String>();
        info.add(name);
        info.add(code);
        info.add(doctor.toString());
        info.add(TA);
        return info;
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
    public void addGrade(String name , int grade ){
        grades.put(name, grade);
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }
    public void setAss(String Ass){
        this.Ass.add(Ass);
    }
    public ArrayList<String> getAss(){
        return Ass;
    }

    @Override
    public String toString() {
        return name;
    }
}
