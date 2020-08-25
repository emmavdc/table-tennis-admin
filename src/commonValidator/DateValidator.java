package commonValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {

    public static GregorianCalendar validateDate(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);

        GregorianCalendar javaDate;
        try
        {
            javaDate = new GregorianCalendar();
            javaDate.setTime(simpleDateFormat.parse(date));

        }
        catch (ParseException e){
            javaDate = null;

        }
        return javaDate;
    }
}
