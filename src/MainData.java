import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class MainData {

    private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";

    public static void main(String[] args) {

        String dateInString = "22-1-2015 10:15:55 AM";
        LocalTime ldt = LocalTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));
        System.out.println(ldt);
    }
}
