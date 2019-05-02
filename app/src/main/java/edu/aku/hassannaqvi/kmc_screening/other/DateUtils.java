package edu.aku.hassannaqvi.kmc_screening.other;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ramsha.ahmed on 4/14/2018.
 */

public class DateUtils {
    public static String getUpdatedDate(String format, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.DATE, days);
        return new SimpleDateFormat(format).format(cal.getTime()); //"dd-MM-yyyy HH:mm"
    }

    public static String getUpdatedDateByMonths(String format, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.MONTH, months);
        return new SimpleDateFormat(format).format(cal.getTime()); //"dd-MM-yyyy HH:mm"
    }

}
