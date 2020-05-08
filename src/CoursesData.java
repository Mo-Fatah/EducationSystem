import java.util.ArrayList;

public class CoursesData {
    private static ArrayList<Course> courses = new ArrayList<Course>();
    public static void addCourse(Course course){
        courses.add(course);
    }
    public static ArrayList<Course> getCourses(){
        return courses;
    }
}
