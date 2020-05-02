import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        ArrayList<Course> courses = new ArrayList<Course>();
        Main mn = new Main();
        mn.fillCourses(courses);
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        mn.fillDoctors(doctors,courses);
        ArrayList<Student> students = new ArrayList<Student>();



    }
    public void fillCourses(ArrayList<Course> courses){
        String[] codes = {"CS1", "CS2" , "CS3" , "CS4" , "CS5", "CS6", "CS7", "CS8" , "CS9" , "CS10"};
        String[] names = {"Programming 1" , "Programming 2" , "Algorithm" , "Data Structure" , "Operating Systems" ,"Networking",
                            "Software Development" , "Software Engineering" , "Project" , "Graduation Project"};

        for(int i = 0 ; i < codes.length; i++){
            courses.add(new Course(names[i] , codes[i]));
        }

    }
    public void fillDoctors(ArrayList<Doctor> doctors,ArrayList<Course> courses ){
        String[] Doctors = {"Mohamed Samy" , "Aly Ahmed" , "Ibrahim" , "Mahmoud" , "Hassan" , "Khalil" , "Osama" , "Nasr Rashid",
                "Ateyat" ,"Peter" };
        for(int i = 0 ; i < Doctors.length; i++){
            doctors.add(new Doctor(Doctors[i] , courses.get(i)));
            courses.get(i).setStaff(doctors.get(i));
        }
    }
    

}
