import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String name;
    private String code;
    private ArrayList<Student> students;
    private Doctor doctor;
    private String TA;
    private ArrayList<Assigment> Ass;
    private HashMap<Student, Integer> grades;
    public Course(String name , String code ){
        this.name = name;
        this.code = code;
        students = new ArrayList<Student>();
        Ass = new ArrayList<Assigment>();
        grades = new HashMap<Student, Integer>();
    }

    public void setStaff(Doctor doctor){
        this.doctor = doctor;
        this.TA = "";
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

    public void addGrade(Student student , int grade ){
        grades.put(student, grade);
    }

    public HashMap<Student, Integer> getGrades() {
        return grades;
    }
//    public void setAss(String Ass){
//        this.Ass.add(Ass);
//    }
//    public ArrayList<String> getAss(){
//        return Ass;
//    }

    @Override
    public String toString() {
        return name + " " + code;
    }

    public String getCode() {
        return code;
    }

    public ArrayList<Assigment> getAss(){
        return Ass;
    }

    public void addAssToStudents(Assigment ass){
        for(int i = 0 ; i < students.size(); i++){
            students.get(i).addAss(this, ass);
        }
    }
    public void addAss(Assigment ass){
        this.getAss().add(ass);
        addAssToStudents(ass);
    }
}
