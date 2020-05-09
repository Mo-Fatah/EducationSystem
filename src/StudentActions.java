import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class StudentActions {
    private Student stdnt;
    public int studentLogin(Scanner input , ArrayList<Student> students){

        boolean badCombination = true;
        this.stdnt = null;
        do{
            System.out.println("\nWelcome Dear Student\n\n0 : Return to the Main Menu\n1 : continue to login");
            if(input.nextInt() == 0)
                return 0;

            System.out.print("Please Enter your id : ");
            int id = input.nextInt();
            System.out.print("\nPlease Enter your Password : ");
            int password = input.nextInt();
            System.out.println();

            for(int i = 0 ; i < students.size(); i++){
                if(students.get(i).Authentication(id,password)){
                    stdnt = students.get(i);
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
        int returned = StudentActions.StudentMenu(stdnt,input);
        if(returned == 0){
            studentLogin(input ,students);
        }

        return returned;
    }

    public static int StudentMenu(Student student , Scanner input){
        System.out.printf("\n\nWelcome %s \n\n",student.getName());
        System.out.println("What do you want to do ?\n1 : View Courses\n2 : Submit Assignment\n3 : Enroll in Course\n4 : View My Grades" +
                "\n5 : Staff Announcement\n0 : LogOut ");
        int choice = input.nextInt();
        int returned = 0;
        switch (choice){
            case 1 : returned = StudentActions.viewCourses(student,input);
                break;
            case 2 : returned = StudentActions.submitAss(student,input);
                break;
            case 3 : returned = StudentActions.enrolInCourse(student,input);
                break;
            case 4 : returned = StudentActions.viewGrades(student,input);
            break;
            case 5 : returned = StudentActions.viewAnn(student, input);
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
                                );
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e){}

        return 0;
    }



    public static int enrolInCourse(Student student,Scanner input){
        ArrayList<Course> currCourses = CoursesData.getCourses();
        System.out.println("Select the You want to enroll in : ");
        for(int i = 0 ; i < currCourses.size(); i++){
            System.out.println(i + ")" +" "+ currCourses.get(i).courseInfo().get(0) +"\t" +
                    currCourses.get(i).courseInfo().get(1));
        }
        System.out.printf("%d) Return to the Main Menu.\n",currCourses.size());
        System.out.print("\nEnter : ");
        // Complete This Function
        int course = input.nextInt();
        if(course == currCourses.size())
            return 0;
        boolean AlreadyEnroled = false;

        for(Course crs : student.getCourses()){//Check if the selected course is already enrolled in
            if(currCourses.get(course) == crs){
                AlreadyEnroled =true;
            }
        }
        if(AlreadyEnroled){// if Already Enrolled , return to the main menu or try again
            System.out.printf("You are already Enrolled in %s \n",currCourses.get(course).getCode());
            int choice;
            do {
                System.out.println("If You want to enroll in a different course Press : 1\nif You want to return to the main menu press : 0");
                choice = input.nextInt();
                if(choice == 1){
                    enrolInCourse(student,input);
                    return 0;
                }
                else if(choice == 0)
                    return 0;
                else
                    System.out.println("Invalid Input");
            }while(choice >1 || choice < 0);

        }

        student.addCourse(currCourses.get(course));
        currCourses.get(course).addStudent(student);
        System.out.println("Successful Enrolment , You will be returned back to Your Main Menu ");
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e){}


        return 0;
    }


    public static int submitAss(Student student , Scanner input){
        System.out.println("Choose the Course you want to submit it's Assignment : ");
        ArrayList<Course> EnrolledCourses = student.getCourses();
        for(int i = 0 ; i < EnrolledCourses.size(); i++){
            System.out.println(i + ")" +" "+ EnrolledCourses.get(i).courseInfo().get(0) +"\t" +
                    EnrolledCourses.get(i).courseInfo().get(1));
        }
        System.out.printf("%d) Return to the Main Menu.\n",EnrolledCourses.size());
        System.out.print("\nEnter : ");
        // Complete This Function
        int courseIdx = input.nextInt();
        if(courseIdx == EnrolledCourses.size()){
            return 0;
        }
        Course course = EnrolledCourses.get(courseIdx);
        ArrayList<HashMap<Assigment,String>> AssList = student.getAssigns().get(course);
        System.out.println(course.toString()+ " " +"Assignments : ");
        ArrayList<Assigment> assIndexing = new ArrayList<Assigment>();
        // This loop will Print each Assignment with it's state of submission.
        // And also it will create a list of Assignments indexed so I can choose from them afterward
        for(int i = 0 ;  i< AssList.size() ; i++){ // iterate over the List Of Assignment
            for (Assigment ass: AssList.get(i).keySet()) {// get the Key and value of Each Assignment
                if(AssList.get(i).get(ass).equals("") ){
                    System.out.println((i+1)+") "+ass.getName() +" :"+"\tnot submitted");
                }
                else{
                    System.out.println((i+1)+") "+ass.getName() + " :" + "\tsubmitted");
                }
                assIndexing.add(ass);
            }
        }
        System.out.println("Note : You can Resubmit an Assignment as long as it's not graded yet by the TA ");
        System.out.print("Choose the Assignment number that you want to Submit or Resubmit(Press 0 if You want to return back) : ");
        int choice  = input.nextInt();
        if(choice == 0){
            submitAss(student,input);
            return 0;
        }
        else{
            if(choice < 0 || choice > assIndexing.size()){
                do{
                    System.out.printf("Please Enter a valid Number (0 - %d) : " ,assIndexing.size());
                    choice = input.nextInt();
                    if(choice == 0){
                        submitAss(student,input);
                        return 0;
                    }
                }while(choice < 0 || choice > assIndexing.size());
            }
        }
        // The Wanted Ass. is choice -1
        System.out.printf("\nThis is the %s Assignment \n",assIndexing.get(choice-1).getName());
        System.out.println(assIndexing.get(choice-1).getContent());
        input.nextLine();
        System.out.println("Enter Your Response : ");
        String solution = input.nextLine();
        for(int i = 0 ; i < AssList.size(); i++){
            if(AssList.get(i).containsKey(assIndexing.get(choice-1))){
                AssList.get(i).put(assIndexing.get(choice-1),solution) ;
            }
        }

        System.out.println("Submission Done , You will be directed to the Main Menu");
        return 0;
    }
    public static int viewGrades(Student student,Scanner input) {
        HashMap<Course, ArrayList<HashMap<Assigment, Integer>>> grades = student.viewGrades();
        ArrayList<Course> courses = new ArrayList<Course>();
        int counter = 1;
        for (Course course : grades.keySet()) {
            int gradePerCourse = -1;
            boolean flag = false;
            courses.add(course);
            System.out.printf("\n%d) %s", counter, course.getCode()+ " : ");
            counter++;
            ArrayList<HashMap<Assigment, Integer>> arr = grades.get(course);
            if(arr == null){
                System.out.print("Nothing Graded Yet");
                continue;
            }

            for (int i = 0; i < arr.size(); i++) {
                for (Assigment ass : arr.get(i).keySet()) {
                    if (arr.get(i).get(ass) == -1) {
                        continue;
                    }
                    else{
                        flag = true;
                        gradePerCourse += arr.get(i).get(ass);
                    }
                }
            }
            if(flag){
                gradePerCourse++;
                System.out.print(gradePerCourse);
            }
            else
                System.out.print("Nothing Graded Yet");
        }

        System.out.println("\nIf you want to view the detailed grades for each Assignment of a course , please Enter the number of the course."
                            +"Enter 0 to return");
        System.out.print("Enter : ");
        int choice = input.nextInt();
        if(choice == 0)
            return 0;
        Course TheCourse = courses.get(choice-1);
        for(Course course : grades.keySet()){
            if(course != TheCourse)
                continue;
            ArrayList<HashMap<Assigment, Integer>> arr = grades.get(course);
            if(arr == null){
                System.out.printf("\n%s No Assignments\n",TheCourse.getCode());
                continue;
            }
            for (int i = 0; i < arr.size(); i++) {
                for (Assigment ass : arr.get(i).keySet()) {
                    if (arr.get(i).get(ass) == -1) {
                        System.out.printf("\n%s : Not Graded Yet\n", ass.getName());
                    }
                    else {
                        System.out.printf("\n%s : %d\n", ass.getName(),arr.get(i).get(ass));
                    }

                }
            }

        }
        System.out.println("If You want to view Another Course Press 1\nTo return press 0");
        System.out.print("Enter : ");
        choice = input.nextInt();
        if(choice == 0)
            return 0;
        viewGrades(student,input);
        return 0;
    }
    public static int viewAnn(Student student,Scanner input){
        System.out.println("Which Course ? ");
        for(int i =0 ; i< student.getCourses().size(); i++){
            System.out.println((i+1) + ")" + " "+student.getCourses().get(i).getCode());
        }
        System.out.println("0 : back");
        System.out.print("\nEnter : ");
        int choice = input.nextInt();
        if(choice == 0)
            return 0;
        Course course = student.getCourses().get(choice -1);
        for(int i = 0 ; i < course.getAnnouncement().size(); i++){
            System.out.printf("\nAnnouncement %d : %s", (i+1), course.getAnnouncement().get(i));
        }
        System.out.print("\nPress 1 to view another course , 0 to return to the Main Menu");
        System.out.print("\nEnter : ");
        choice = input.nextInt();
        if(choice == 0)
            return 0;
        if (choice == 1)
            viewAnn(student,input);
        return 0;
    }






}
