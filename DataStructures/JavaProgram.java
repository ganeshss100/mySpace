import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gsrinivasagam on 11/18/2017.
 */
public class JavaProgram {
    public static void main(String[] args) {
        //System.out.println("Hello");
        Map<String, Double> hashMap = new HashMap<>();
        int n=10;
        for(int i=0;i<n;i++){
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
            hashMap.put(sf.format(cal.getTime()),Math.random()*1000);
            System.out.println(hashMap);
        }
    }
}
