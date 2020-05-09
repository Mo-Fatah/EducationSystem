import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private int id;
    private String name;
    private int password;
    private ArrayList<Course> courses;
    private HashMap<Course, ArrayList<HashMap<Assigment,Integer>>> grades;
    private String email;
    private HashMap<Course,ArrayList<HashMap<Assigment,String>>> assigns;
//    private HashMap<> assStatus;

    public Student(int id , String name){
        this.id = id;
        this.name = name;
        grades = new HashMap<Course, ArrayList<HashMap<Assigment,Integer>>>();
        courses = new ArrayList<Course>();
        assigns = new HashMap<Course,ArrayList<HashMap<Assigment,String>>>();
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



    public void addCourse(Course course){
        this.courses.add(course);
        this.grades.put(course,null);
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


    // This Method Adds All the Assignment that was created in the new Enrolled course
    // This Method should be called at the of addCourse Method
    public void addAllAssigns(Course course){
        ArrayList<Assigment> ass= course.getAss();
        HashMap<Assigment,String> hashForthisAss  = new  HashMap<Assigment,String>() ;
        ArrayList<HashMap<Assigment,String>> ArrForCourse =new  ArrayList<HashMap<Assigment,String>>();
        for(int j = 0 ; j < ass.size(); j ++){
            hashForthisAss.put(ass.get(j), "");
            ArrForCourse.add(hashForthisAss);
            this.addGrade(course,ass.get(j) ,-1 );

        }
        assigns.put(course,ArrForCourse);

    }

    // Different from the above method , This method add the new created assignment by the doctor -of a course that I a student enrolled in -
    // to the assigns variable
    public void addAss(Course course , Assigment ass){
        HashMap<Assigment,String> newAss= new HashMap<Assigment,String>();
        newAss.put(ass,"");
//        assigns.get(course);
        assigns.get(course).add(newAss);
        this.addGrade(course,ass, -1);

    }
    public HashMap<Course, ArrayList<HashMap<Assigment, String>>> getAssigns() {
        return assigns;
    }

   // This Method should be Called 3 times :
    // 1 - Mainly by the TA to put A value in the grade
    // 2 - in the Method addAllAssigns so with each course added , it's assignments paired with a null grade are added
    // 3 - in the Method addAss so with each new Ass Added , it will be added automatically to the grades with a null value
    public void addGrade(Course course , Assigment ass, Integer grade){
        HashMap<Assigment,Integer> thisGrade = new HashMap<Assigment,Integer>();
        thisGrade.put(ass,grade);
        if(grades.get(course) == null){
            ArrayList<HashMap<Assigment, Integer>> thisArr = new ArrayList<HashMap<Assigment, Integer>>();
            thisArr.add(thisGrade);
            this.grades.put(course, thisArr);
        }
        else
            this.grades.get(course).add(thisGrade);
    }

    public HashMap<Course, ArrayList<HashMap<Assigment,Integer>>> viewGrades (){
        return grades;
    }


}
