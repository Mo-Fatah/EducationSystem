public class Assigment {
    // the name of the Assignment
    private String name;
    // The Course of the Assignment
    private Course course;
    private Student student;
    private String content;
    /*
        The Assignment is Created by a doctor and graded by a TA .
        Each Course have several Assignments.
     */

    public Assigment(String name , Course course){
        this.name =name;
        this.course = course;
        course.getAss().add(this);
    }
    // Used by Doctor
    public void addContent(String content){
        this.content = content;
    }
    // Used by Student

    // Used by TA

    public Course getCourse() {
        return course;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }



}
