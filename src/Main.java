import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Course> courses = CoursesData.getCourses();
        Main.fillCourses(courses);
        ArrayList<Doctor> doctors = DoctorsData.getDoctors();
        Main.fillDoctors(doctors,courses);
        ArrayList<Student> students = StudentsData.getStudents();
        Main.fillStudents(students,courses);
        Scanner input = new Scanner(System.in);
        while (true){

            System.out.println("Welcome , User");
            System.out.print("\nPlease Select an Action \n1 : Student\n2 : Doctor \n3 : Staff\n4 : Quit\n Enter Your Choice : ");
            int choice = input.nextInt();
            while (choice < 1 || choice > 4){
                System.out.println("Invalid Input ");
                System.out.print("\nPlease Select an Action \n1: Student\n 2:Doctor \n3 : Staff\n4 : Quit\nEnter Your Choice : ");
                choice = input.nextInt();
            }
            int returned = 0;
            switch (choice){
                case 1 :
                    StudentActions student = new StudentActions();
                    returned = student.studentLogin(input ,students);
                break;
                case 2 : returned = Main.DoctorLogin(input);
                break;
                case 3 : returned = Main.StaffLogin(input);
                break;
                case 4 : System.exit(1);
                break;
            }
            if(returned == 0 ){
                continue;
            }

        }












    }
    public static ArrayList<Course> fillCourses(ArrayList<Course> courses){
        String[] codes = {"CS1", "CS2" , "CS3" , "CS4" , "CS5", "CS6", "CS7", "CS8" , "CS9" , "CS10"};
        String[] names = {"Programming 1" , "Programming 2" , "Algorithm" , "Data Structure" , "Operating Systems" ,"Networking",
                            "Software Development" , "Software Engineering" , "Project" , "Graduation Project"};

        for(int i = 0 ; i < codes.length; i++){
            courses.add(new Course(names[i] , codes[i]));
        }
        return courses;

    }
    public static void fillDoctors(ArrayList<Doctor> doctors,ArrayList<Course> courses ){
        String[] Doctors = {"Mohamed Samy" , "Aly Ahmed" , "Ibrahim" , "Mahmoud" , "Hassan" , "Khalil" , "Osama" , "Nasr Rashid",
                "Ateyat" ,"Peter" };
        for(int i = 0 ; i < Doctors.length; i++){
            doctors.add(new Doctor(Doctors[i] , courses.get(i)));
            courses.get(i).setStaff(doctors.get(i));
            doctors.get(i).setPassword(10000-i);
        }
    }
    public static void fillStudents(ArrayList<Student> students,ArrayList<Course> courses){
        String[] RandStudents = {"Aly" , "Hossam" , "Ibrahim" , "Esaam" , "Mahmoud" , "Mohamed", "Gaber", "Loay", "Islam" , "Momen"
                                    , "Nour" , "Walaa" , "Salma" , "Somaia" , "Asmaa" , "Hoor" ,"Nany" , "Alexa" , "Karma" , "Khadija"
                                ,"Wessam" , "Abeer" , "Abdelrahaman"};
        for(int i = 0 ; i < RandStudents.length; i++ ){
            students.add(new Student(i,RandStudents[i]));
            Random rand = new Random();
            signInCourse(students.get(i), courses.get(rand.nextInt(courses.size())));
            students.get(i).setPassword(10000-i);
        }
    }
    public static void signInCourse(Student student , Course course){
        student.addCourse(course);
        course.addStudent(student);
    }

    // Student Login
    public static int DoctorLogin(Scanner input){
        return 0;
    }
    public static int StaffLogin(Scanner input){
        return 0;
    }






}
