import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private int id;
    private String name;
    private int password;
    private ArrayList<String> courses;
    private HashMap<String, Integer> grades;
    private String email;

    public Student(int id , String name){
        this.id = id;
        this.name = name;
    }
    public void setPassword(int pass){ // The password should be integer numbers Only
        this.password = pass;
    }
    public ArrayList<String> viewCourses(){
        return courses;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public HashMap<String, Integer> viewGrades (){
        return grades;
    }
    public void addCourse(String course){
        this.courses.add(course);
    }
    public boolean addGrade(String course, int grade){
        if(!courses.contains(course)){
            return false;
        }
        if(! grades.containsKey(course)){
            grades.put(course, grade);
        }
        else{
            int lastGrade = grades.get(course);
            grades.put(course, lastGrade +grade);
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






}
