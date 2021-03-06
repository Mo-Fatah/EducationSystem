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
        ArrayList<TA> tas = TAsData.getTAs();
        Main.fillTAs(tas);
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
            if(choice == 4)
                System.exit(1);

            System.out.print("\n0 : Sign-in\n1 : Sing-up");
            System.out.print("\nEnter : ");
            int choice2 = input.nextInt();
            if(choice2 == 1){
                switch (choice){
                    case 1 :
                        StudentActions student = new StudentActions();
                        student.signUp(input);
                        break;
                    case 2 :
                        DoctorActions doctor = new DoctorActions();
                        doctor.signUp(input);
                        break;
                    case 3 :
                        TAActions ta = new TAActions();
                        ta.signUp(input);
                        break;
                    case 4 : System.exit(1);
                        break;
                }
                continue;
            }

            switch (choice){
                case 1 :
                    StudentActions student = new StudentActions();
                    student.studentLogin(input ,students);
                break;
                case 2 :
                    DoctorActions doctor = new DoctorActions();
                    doctor.DoctorLogin(input,doctors);
                break;
                case 3 :
                    TAActions ta = new TAActions();
                    ta.TALogin(input,tas);
                break;
                case 4 : System.exit(1);
                break;
            }
        }
    }

    public static int DoctorLogin(Scanner input){
        return 0;
    }

    public static int StaffLogin(Scanner input){
        return 0;
    }

    // Dummy Data Generation
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
            doctors.add(new Doctor(i , Doctors[i]));
            courses.get(i).setStaff(doctors.get(i));
            doctors.get(i).setPassword(10000-i);
            doctors.get(i).addCourse(courses.get(i));
        }
    }
    public static void fillStudents(ArrayList<Student> students,ArrayList<Course> courses){
        String[] RandStudents = {"Aly" , "Hossam" , "Ibrahim" , "Esaam" , "Mahmoud" , "Mohamed", "Gaber", "Loay", "Islam" , "Momen"};
        for(int i = 0 ; i < RandStudents.length; i++ ){
            students.add(new Student(i,RandStudents[i]));
            signInCourse(students.get(i), courses.get(i));
            students.get(i).setPassword(10000-i);
        }
    }
    public static void fillTAs(ArrayList<TA> tas){
        String[] RandTas = {"Aly" , "Hossam" , "Ibrahim" , "Esaam" , "Mahmoud" , "Mohamed", "Gaber", "Loay", "Islam" , "Momen"
                , "Nour" , "Walaa"};
        for(int i = 0 ; i < RandTas.length ; i++){
            tas.add(new TA(i,RandTas[i]));
            tas.get(i).setPassword(10000-i);

        }
    }


    // This Method Only For Dummy Data Generation
    private static void signInCourse(Student student , Course course){
        student.addCourse(course);
        course.addStudent(student);
    }



    // Student Login







}
