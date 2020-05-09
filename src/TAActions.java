import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TAActions {
    private TA ta;
    public int TALogin(Scanner input , ArrayList<TA> tas){

        boolean badCombination = true;
        this.ta = null;
        do{
            System.out.println("\nWelcome Teaching Assistant\n\n0 : Return to the Main Menu\n1 : continue to login");
            if(input.nextInt() == 0)
                return 0;

            System.out.print("Please Enter your id : ");
            int id = input.nextInt();
            System.out.print("\nPlease Enter your Password : ");
            int password = input.nextInt();
            System.out.println();

            for(int i = 0 ; i < tas.size(); i++){
                if(tas.get(i).Authentication(id,password)){
                    ta = tas.get(i);
                    badCombination = false;
                    break;
                }
            }
            if(badCombination){
                System.out.println("Invalid id/Password , please wait and try again");
                try {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException e){}
            }

        }while(badCombination);
        int returned = TAActions.TAMenu(ta,input);
        if(returned == 0){
            TALogin(input ,tas);
        }

        return returned;
    }
    public static int TAMenu(TA ta, Scanner input){
        System.out.printf("\nWelcome %s\n" ,ta.getName());
        System.out.println("What do you want to do ? : ");
        System.out.println("1 : Grade Assignments\n2 : Make Announcement\n0 : LogOut");
        System.out.print("Enter choice : ");
        int choice = input.nextInt();
        switch (choice){
            case 1 : TAActions.GradeAss(ta , input);
            break;
            case 2 : TAActions.makeAnn(ta,input);
            break;
            case 0 : return 0 ;
        }
        TAMenu(ta,input);
        return 0 ;
    }
    public static int GradeAss(TA ta , Scanner input){
        System.out.println("Which Course ? : ");
        if(ta.getCourses() == null){
            System.out.println("You are not assigned to any course yet");
            return 0 ;
        }
        for(int i = 0 ; i < ta.getCourses().size() ; i++){
            System.out.printf("\n"+(i+1) + ") " + "%s\n ", ta.getCourses().get(i).getCode());
        }
        System.out.println("0 : back");
        System.out.print("\nEnter : ");
        int choice = input.nextInt();
        if(choice == 0)
            return 0 ;
        Course course = ta.getCourses().get(choice -1);
        ArrayList<Student> students = course.getStudents();
        do {
            System.out.println("Which Student you want to grade ? :");
            for(int i = 0 ; i < students.size() ; i ++){
                System.out.printf("\n"+(i+1)+") %d %s" , students.get(i).getId(),students.get(i).getName());
            }
            System.out.println("\n0 : back");
            System.out.print("\nEnter : ");
            choice =input.nextInt();
            if(choice == 0){
                GradeAss(ta,input);
                return 0;
            }
            Student student = students.get(choice -1);
            ArrayList<HashMap<Assigment,String>> assigns = student.getAssigns().get(course);
            ArrayList<HashMap<Assigment,Integer>> assignsGrades = student.viewGrades().get(course);
            if(assigns == null || assigns.size() == 0){
                System.out.println("No Assignments Yet");
                continue;
            }
            for(int i = 0 ; i < assigns.size(); i++){
                for(Assigment ass : assignsGrades.get(i).keySet()){
                    if(assignsGrades.get(i).get(ass) == -1 ){
                        System.out.printf("\nThe Response of %s is : %s\n",student.getName(),assigns.get(i).get(ass));
                        System.out.print("\nEnter grade (Enter -1 to skip) : ");
                        int grade = input.nextInt();
                        if(grade == -1 )
                            continue;
                        assignsGrades.get(i).put(ass,grade);
                        System.out.println("Grade sent to Student");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        }
                        catch (InterruptedException e){}
                    }
                }
            }
        }while(choice != 0);
        return 0;
    }
    public static int makeAnn(TA ta , Scanner input){
        System.out.println("Which Course?");
        if(ta.getCourses().size() == 0)
            System.out.println("You are not added to any Course Yet");
        for(int i =0 ;i < ta.getCourses().size(); i++){
            System.out.println((i+1) + ")" + " "+ta.getCourses().get(i).getCode());
        }
        System.out.println("0 : back");
        System.out.print("\nEnter : ");
        int choice = input.nextInt();
        if(choice == 0)
            return 0;
        Course course = ta.getCourses().get(choice -1);
        System.out.print("Enter Announcement : ");
        input.nextLine();
        String ann = input.nextLine();
        course.submitAnn(ann);
        System.out.print("Announcement Added to the Course Successfully, You will be returned to the Main Menu");
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e){}
        return 0;
    }
    public static void signUp(Scanner input){
        System.out.print("\n\nPlease Enter Your first name : ");
        input.nextLine();
        String name = input.nextLine();
        Random r = new Random();
        int pass;
        int id;
        do {
            int low = 100;
            int high = 1000;
            id = r.nextInt(high-low) + low;
            low = 10000;
            high = 100000;
            pass = r.nextInt(high-low) + low;
        }while(! TAsData.verifyPassId(pass,id));
        TA ta = new TA(id , name);
        ta.setPassword(pass);
        TAsData.getTAs().add(ta);
        System.out.printf("\nSuccessful Sign-up as A Teaching Assistant\nYour ID is : %d\nyour Password is : %d", id,pass);
        System.out.println("\nPress 0 to return ");
        System.out.print("\nEnter : ");
        input.nextInt();
    }
}
