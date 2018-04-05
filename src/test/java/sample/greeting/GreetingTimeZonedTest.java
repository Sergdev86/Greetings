package sample.greeting;


import org.junit.Test;
import static org.junit.Assert.*;

public class GreetingTimeZonedTest {


    @Test
    public void testSalute(){

        assertEquals("Good night, Tokyo!", GreetingTimeZoned.salute(0, GreetingTimeZoned.TimesOfDay.NIGHT, "Tokyo"));
        assertEquals("Good morning, Tokyo!", GreetingTimeZoned.salute(6, GreetingTimeZoned.TimesOfDay.MORNING, "Tokyo"));
        assertEquals("Good day, Tokyo!", GreetingTimeZoned.salute(9, GreetingTimeZoned.TimesOfDay.DAY, "Tokyo"));
        assertEquals("Good evening, Tokyo!", GreetingTimeZoned.salute(19, GreetingTimeZoned.TimesOfDay.EVENING, "Tokyo"));

    }

    @Test
    public void testParseCityName(){

        assertEquals("Tokyo", GreetingTimeZoned.parseCityName("Asia/Tokyo"));
        assertEquals("Tokyo", GreetingTimeZoned.parseCityName("Tokyo"));
        assertFalse("Tokyo".equals(GreetingTimeZoned.parseCityName("")));

    }

}
