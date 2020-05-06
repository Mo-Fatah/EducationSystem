public class Assigment {
    // the name of the Assignment
    private String name;
    // The Course of the Assignment
    private Course course;
    private Student student;
    private String content;
    private String solution;
    private double grade;
    public Assigment(String name , Course course){
        this.name =name;
        this.course = course;
    }
    // Used by Doctor
    public void addContent(String content){
        this.content = content;
    }
    // Used by Student
    public void subitAns(String ans){
        this.solution = ans;
    }
    // Used by TA
    public void addGrade(double grade){
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public double getGrade() {
        return grade;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getSolution() {
        return solution;
    }
    
}
