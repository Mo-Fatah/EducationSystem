import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Course> courses = new ArrayList<Course>();
        Main mn = new Main();
        mn.fillCourses(courses);
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        mn.fillDoctors(doctors,courses);
        ArrayList<Student> students = new ArrayList<Student>();
        mn.fillStudents(students,courses);
        while (true){
            System.out.println("Continue as \n 0 Student \n 1 Doctor \n please Enter a number");
            Scanner input = new Scanner(System.in);
            int in = input.nextInt();

            while ( in != 0 && in != 1){
                System.out.println("Please Enter a Valid Number (0 or 1): ");
                in = input.nextInt();
            }
            if ( in == 0){
                System.out.println("Welcome Dear Student , Please Select an Action to continue \n 0 : Sign-up \n 1 : Sign-in \n 2 : back");
                int inStudent = input.nextInt();
                while (inStudent != 0 && inStudent != 1 && inStudent != 2 ){
                    System.out.println("Please Enter a Valid Number: ");
                    inStudent = input.nextInt();
                }
                if(inStudent == 2)
                    continue;
                if(inStudent == 0){ // Sign Up for A new Student
                    System.out.println("Welcome New Student , Please Enter A username");
                    String username = input.nextLine();
                    System.out.println("Great!! ,Please Enter a unique Password of 4 digits (Numbers Only)");
                    int password = input.nextInt();
                    int id = students.size();
                    Student newSt = new Student(id , username);
                    newSt.setPassword(password);
                    students.add(newSt);
                    System.out.println("Thank You, " + username + "."+"You have singed up successfully " + "\n You ID is " + " id" );
                    continue;
                }
                


            }


        }



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
            doctors.get(i).setPassword(10000-i);
        }
    }
    public void fillStudents(ArrayList<Student> students,ArrayList<Course> courses){
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
    public void signInCourse(Student student , Course course){
        student.addCourse(course);
        course.addStudent(student);
    }




}
