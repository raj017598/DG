package munni.priyanka.dg;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Methods {


    public static String getJoiningDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String todayDate = dateFormat.format(calendar.getTime());
        return todayDate;
    }
}
