package edu.aku.hassannaqvi.kmc.other;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeUtils {
    public static String getYearsBack(String format, int year){
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.YEAR, year);
        return new SimpleDateFormat(format).format(cal.getTime()).toString(); //"dd-MM-yyyy HH:mm"
    }
}
