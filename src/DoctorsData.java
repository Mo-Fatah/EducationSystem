import java.util.ArrayList;

public class DoctorsData {
    private static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    public static void addDoctor(Doctor doc){
        doctors.add(doc);
    }
    public static ArrayList<Doctor> getDoctors(){
        return doctors;
    }
    public static boolean verifyPassId(int pass , int id){
        for(Doctor doctor : doctors){
            if(doctor.getId() == id || doctor.getPassword() == pass){
                return false;
            }
        }

        return true;
    }
}
