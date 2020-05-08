import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;

public class TA {
    private String name;
    private int id;
    private int password;
    private ArrayList<Course> course;

    public TA(String name){
        this.name = name;
        course = new ArrayList<Course>();
    }
    public void setPassword(int password) {
        this.password = password;
    }

    public void addCourse(Course course){
        this.course.add(course);
    }


}
