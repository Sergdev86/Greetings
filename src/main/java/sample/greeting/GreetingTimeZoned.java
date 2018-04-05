package sample.greeting;


import java.time.*;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*public enum GreetingTimeZoned {

    MORNING(6, 9),
    DAY(9, 19),
    EVENING(19, 23),
    NIGHT(23, 6);

    private static ResourceBundle message = ResourceBundle.getBundle("message");


    private int start;
    private int end;


    GreetingTimeZoned(int start, int end) {
        this.start = start;
        this.end = end;
    }


    public String salute(int currentTime, String timesOfDay, String cityName) {
        String greeting = "";
        if("night".equals(timesOfDay)){
            if(currentTime >= start || currentTime < end){
                greeting = message.getString("greeting.".concat(timesOfDay));
                greeting = greeting.concat(" ").concat(cityName).concat("!");
                return greeting;
            }
        }
        if(currentTime >= start && currentTime < end){
            greeting = message.getString("greeting.".concat(timesOfDay));
            greeting = greeting.concat(" ").concat(cityName).concat("!");
            return greeting;
        }
        return "";
    }


    public static String parseCityName(String name){
        int ind = name.indexOf("/");
        if(ind >= 0){
            name = name.substring(ind+1);
        }
        ind = name.indexOf("_");
        if(ind >= 0){
            name = name.replace("_", " ");
        }
        return name;
    }


    public static void main(String args[]) {

        Logger logger = LogManager.getLogger(GreetingTimeZoned.class);
        String arg = args[0];
        String cityName;
        String greeting = "";
        int hour;

        ZoneId zone;
        ZonedDateTime zdt;

        try{
            zone = ZoneId.of(arg);
            zdt = ZonedDateTime.now(zone);
            hour = zdt.getHour();
            cityName = parseCityName(arg);
        }catch(DateTimeException dte){
            zdt = ZonedDateTime.now(ZoneId.systemDefault());
            hour = zdt.getHour();
            cityName = parseCityName(arg);
        }

        for (GreetingTimeZoned timesOfDay : GreetingTimeZoned.values()){
            greeting = timesOfDay.salute(hour, timesOfDay.name().toLowerCase(), cityName);
            if(!("".equals(greeting))){
                break;
            }
        }
        logger.info(greeting);
    }

}*/
public class GreetingTimeZoned {

    enum TimesOfDay{
        MORNING(6, 9),
        DAY(9, 19),
        EVENING(19, 23),
        NIGHT(23, 6);

        private int start;
        private int end;

        TimesOfDay(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static ResourceBundle message = ResourceBundle.getBundle("message");


    public static String salute(int currentTime, TimesOfDay timesOfDay, String cityName) {
        String time = timesOfDay.name().toLowerCase();
        String greeting = "";
        if("night".equals(timesOfDay)){
            if(currentTime >= timesOfDay.start || currentTime < timesOfDay.end){
                greeting = message.getString("greeting.".concat(time));
                greeting = greeting.concat(" ").concat(cityName).concat("!");
                return greeting;
            }
        }
        if(currentTime >= timesOfDay.start && currentTime < timesOfDay.end){
            greeting = message.getString("greeting.".concat(time));
            greeting = greeting.concat(" ").concat(cityName).concat("!");
            return greeting;
        }
        return greeting;
    }


    public static String parseCityName(String name){
        int ind = name.indexOf("/");
        if(ind >= 0){
            name = name.substring(ind+1);
        }
        ind = name.indexOf("_");
        if(ind >= 0){
            name = name.replace("_", " ");
        }
        return name;
    }


    public static void main(String args[]) {

        Logger logger = LogManager.getLogger(GreetingTimeZoned.class);
        String arg = "Asia/Tokyo";//args[0];
        String cityName;
        String greeting = "";
        int hour;

        ZoneId zone;
        ZonedDateTime zdt;

        try{
            zone = ZoneId.of(arg);
            zdt = ZonedDateTime.now(zone);
            hour = zdt.getHour();
            cityName = parseCityName(arg);
        }catch(DateTimeException dte){
            zdt = ZonedDateTime.now(ZoneId.systemDefault());
            hour = zdt.getHour();
            cityName = parseCityName(arg);
        }

        for (TimesOfDay timesOfDay : TimesOfDay.values()){
            greeting = salute(hour, timesOfDay, cityName);
            if(!("".equals(greeting))){
                break;
            }
        }
        logger.info(greeting);
    }

}