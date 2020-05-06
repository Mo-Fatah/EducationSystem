import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private int id;
    private String name;
    private int password;
    private ArrayList<Course> courses;
    private HashMap<Course, Integer> grades;
    private String email;
    private HashMap<Course,ArrayList<HashMap<Assigment,String>>> assigns;
//    private HashMap<> assStatus;

    public Student(int id , String name){
        this.id = id;
        this.name = name;
        grades = new HashMap<Course, Integer>();
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

    public HashMap<Course, Integer> viewGrades (){
        return grades;
    }

    public void addCourse(Course course){
        this.courses.add(course);
        this.addAllAssigns(course);
    }

//    public boolean addGrade(Course course, int grade){
//        if(!courses.contains(course)){
//            return false;
//        }
//        if(! grades.containsKey(course.toString())){
//            grades.put(course.toString(), grade);
//        }
//        else{
//            int lastGrade = grades.get(course.toString());
//            grades.put(course.toString(), lastGrade +grade);
//        }
//        return true;
//    }
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

    public void enroll(Course course){
        this.addCourse(course);
        course.addStudent(this);
    }
    // This Method Adds All the Assignment that was created in the new Enrolled course
    // This Method should be called at the of addCourse Method
    public void addAllAssigns(Course course){
        ArrayList<Assigment> ass= course.getAss();
        HashMap<Assigment,String> hashForthisAss  = new  HashMap<Assigment,String>() ;
        ArrayList<HashMap<Assigment,String>> ArrForCourse =new  ArrayList<HashMap<Assigment,String>>();
        for(int j = 0 ; j < ass.size(); j ++){
            hashForthisAss.put(ass.get(j), "");
            ArrForCourse.add(hashForthisAss);
        }
        assigns.put(course,ArrForCourse);
    }
    // Different from the above method , This method add the new created assignment by the doctor -of a course that I a student enrolled in -
    // to the assigns variable


    public HashMap<Course, ArrayList<HashMap<Assigment, String>>> getAssigns() {
        return assigns;
    }
    public void addAss(Course course , Assigment ass){
        HashMap<Assigment,String> newAss= new HashMap<Assigment,String>();
        newAss.put(ass,"");
//        assigns.get(course);
        assigns.get(course).add(newAss);

    }
}
