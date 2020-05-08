import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DoctorActions {

    private Doctor doc;
    public int DoctorLogin(Scanner input , ArrayList<Doctor> doctors){

        boolean badCombination = true;
        this.doc = null;
        do{
            System.out.println("\nWelcome Doctor\n\n0 : Return to the Main Menu\n1 : continue to login");
            if(input.nextInt() == 0)
                return 0;

            System.out.print("Please Enter your id : ");
            int id = input.nextInt();
            System.out.print("\nPlease Enter your Password : ");
            int password = input.nextInt();
            System.out.println();

            for(int i = 0 ; i < doctors.size(); i++){
                if(doctors.get(i).Authentication(id,password)){
                    doc = doctors.get(i);
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
        int returned = DoctorActions.DoctorMenu(doc,input);
        if(returned == 0){
            DoctorLogin(input ,doctors);
        }

        return returned;
    }
    public static int DoctorMenu(Doctor doctor , Scanner input){
        System.out.printf("\nWelcome Dr.%s" , doctor.getName());
        System.out.println("What do You want to do ?" +
                "\n1 : Create Assignment \n2 : View Students Performance \n3 : Create Course \n0 : LogOut");
        System.out.print("Enter : ");
        int choice = input.nextInt();
        if(choice > 3 || choice < 0){
            do{
                System.out.print("Invalid input. Enter (0-3) : ");
                choice = input.nextInt();
            }while(choice > 3 || choice < 0);
        }
        switch (choice){
            case 1 : DoctorActions.createAss(doctor,input);
            break;
            case 2 : DoctorActions.viewPerf(doctor,input);
            break;
            case 3 : DoctorActions.createCourse(doctor,input);
            break;
            case 0 : return 0;
            break;
        }
        DoctorMenu(doctor,input);
        return 0 ;
    }

    public static int createAss(Doctor doctor , Scanner input){
        System.out.println("Which course you want to create an assignment ? : ");
        for(int i = 0 ; i < doctor.getCourses().size(); i++){
            System.out.printf("\n"+(i+1) + ") %s" ,doctor.getCourses().get(i).getCode());
        }
        System.out.print("Enter : ");
        int choice = input.nextInt();
        if(choice < 0 || choice > doctor.getCourses().size()-1){
            do {
                System.out.print("\nInvalid input, Enter again : ");
                choice = input.nextInt();
            }while(choice < 0 || choice > doctor.getCourses().size()-1);
        }
        Course course = doctor.getCourses().get(choice-1);
        System.out.println(course.toString());
        System.out.print("\nEnter the title : ");
        input.next();
        String name = input.nextLine();
        Assigment ass = new Assigment(name ,course);
        System.out.print("\nEnter The Content( Enter = Submit) : ");
        String content = input.nextLine();
        ass.addContent(content);
        System.out.print("\n Assignment added successfully.\nEnter 1 : to submit another Assignment \n0 : to go back\n");
        System.out.print("Enter : ");
        choice = input.nextInt();
        if(choice == 0)
            return 0;
        createAss(doctor,input);
        return 0;
    }

    public static int viewPerf(Doctor doctor , Scanner input){
        return 0;
    }

    public static int createCourse(Doctor doctor , Scanner input){
        return 0;
    }
}
