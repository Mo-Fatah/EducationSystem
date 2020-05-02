import javax.print.Doc;
import java.util.ArrayList;

public class Doctor {
    private String name;
    private Course course;
    private int password;

    public Doctor(String name, Course course){
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return name;
    }

    public Course getCourse() {
        return course;
    }
    public void setPassword(int pass){
        this.password = pass;
    }
}
