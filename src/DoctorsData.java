import java.util.ArrayList;

public class DoctorsData {
    private static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    public static void addDoctor(Doctor doc){
        doctors.add(doc);
    }
    public static ArrayList<Doctor> getDoctors(){
        return doctors;
    }
}
