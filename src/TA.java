import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;

public class TA {
    private String name;
    private int id;
    private int password;
    private ArrayList<Course> courses;

    public TA(int id ,String name){
        this.name = name;
        this.id = id;
        courses = new ArrayList<Course>();
    }
    public void setPassword(int password) {
        this.password = password;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
    public boolean Authentication(int id , int password){
        return this.id == id && this.password == password;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }
}
