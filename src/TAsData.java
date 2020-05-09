import java.util.ArrayList;

public class TAsData {
    private static ArrayList<TA> tas = new ArrayList<TA>();
    public static void addStudent(TA ta){
        tas.add(ta);
    }
    public static ArrayList<TA> getTAs(){
        return tas;
    }
}
