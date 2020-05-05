import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private int id;
    private String name;
    private int password;
    private ArrayList<Course> courses;
    private HashMap<String, Integer> grades;
    private String email;

    public Student(int id , String name){
        this.id = id;
        this.name = name;
        grades = new HashMap<String, Integer>();
        courses = new ArrayList<Course>();
    }
    public void setPassword(int pass){ // The password should be integer numbers Only
        this.password = pass;
    }

    public boolean Authentication(int id , int password){
        return this.id == id && this.password == password;
    }

    public ArrayList<Course> viewCourses(){
        return courses;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public HashMap<String, Integer> viewGrades (){
        return grades;
    }

    public void addCourse(Course course){
        this.courses.add(course);

    }

    public boolean addGrade(Course course, int grade){
        if(!courses.contains(course)){
            return false;
        }
        if(! grades.containsKey(course.toString())){
            grades.put(course.toString(), grade);
        }
        else{
            int lastGrade = grades.get(course.toString());
            grades.put(course.toString(), lastGrade +grade);
        }
        return true;
    }
    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public int getPassword(){
        return password;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }
    public void enrol(Course course){
        this.addCourse(course);
        course.addStudent(this);
    }







}
