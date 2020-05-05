import java.util.ArrayList;
import java.util.Scanner;

public class StudentActions {
    private Student stdnt;
    public int studentLogin(Scanner input , ArrayList<Student> students){

        boolean badCombination = true;
        this.stdnt = null;
        do{
            System.out.println("\nWelcome Dear Student\n0 : Return to the Main Menu\n1 : continue ");
            if(input.nextInt() == 0)
                return 0;

            System.out.print("Please Enter your id : ");
            int id = input.nextInt();
            System.out.print("\nPlease Enter your Password : ");
            int password = input.nextInt();


            for(int i = 0 ; i < students.size(); i++){
                if(students.get(i).Authentication(id,password)){
                    stdnt = students.get(i);
                    badCombination = false;
                    break;
                }
            }

        }while(badCombination);
        int returned = StudentActions.StudentMenu(stdnt,input);
        if(returned == 0){
            studentLogin(input ,students);
        }

        return returned;
    }

    public static int StudentMenu(Student student , Scanner input){
        System.out.printf("\n\nWelcome %s \n\n",student.getName());
        System.out.println("What do you want to do ?\n1 : View Courses\n2 : Submit Assignment\n3 : Enroll in Course\n0 : LogOut ");
        int choice = input.nextInt();
        int returned = 0;
        switch (choice){
            case 1 : returned = StudentActions.viewCourses(student,input);
                break;
            case 2 : returned = StudentActions.submitAss(student,input);
                break;
            case 3 : returned = StudentActions.enrolInCourse(student,input);
                break;
            case 0 : return 0;

        }
        if(returned == 0){
            StudentMenu(student ,input);
        }
        return returned;

    }
    public static int viewCourses(Student student , Scanner input){
        ArrayList<Course> courses = student.getCourses();
        System.out.println("You Enrolled in the following courses:");
        for(int i = 0 ; i < courses.size() ;i++){
            System.out.println(courses.get(i).courseInfo().get(0)+" " +courses.get(i).courseInfo().get(1)
                                +"\n" +"Doctor : " + courses.get(i).courseInfo().get(2)
                                +". "+ "TA : " + courses.get(i).courseInfo().get(3));
        }
        return 0;
    }
    public static int submitAss(Student student , Scanner input){
        return 0;
    }
    public static int DoAnything(Student student , Scanner input){
        return 0;
    }
    public static int enrolInCourse(Student student,Scanner input){
        ArrayList<Course> currCourses = CoursesData.getCourses();
        System.out.println("Select the You want to enroll in : ");
        for(int i = 0 ; i < currCourses.size(); i++){
            System.out.println(i + ")" +" "+ currCourses.get(i).courseInfo().get(0) +"\t" +
                    currCourses.get(i).courseInfo().get(1));
        }
        return 0;
    }

}
