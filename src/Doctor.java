import javax.print.Doc;
import java.util.ArrayList;

public class Doctor {
    private int id;
    private String name;
    private ArrayList<Course> courses;
    private int password;

    public Doctor(int id , String name){
        this.id = id;
        this.name = name;
        courses = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void setPassword(int pass){
        this.password = pass;
    }
    public boolean Authentication(int id , int password){
        return this.id == id && this.password == password;
    }
//    public void creatASS(Course course){
        //


//    }
    public void addCourse(Course course){
        this.courses.add(course);
        course.setStaff(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name;
    }

    public int getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
}
