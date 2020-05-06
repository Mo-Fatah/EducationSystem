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
    public void creatASS(){
        //
        // When you create this method, you have to you have to add this new Assignment to all Students enrolled in the course>>
        //>> by addAssToStudents() method in the Course Class.
    }
}
