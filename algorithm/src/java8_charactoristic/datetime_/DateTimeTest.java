package java8_charactoristic.datetime_;

import java.time.*;
import java.util.Base64;

public class DateTimeTest {

    public static void main(String[] args) {
        //获取当前日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("currentTime = " + currentTime);

        LocalDate localDate = currentTime.toLocalDate();
        System.out.println("localDate = " + localDate);

        System.out.println("getMonth -> " + currentTime.getMonth());
        System.out.println("getDayOfMonth -> " + currentTime.getDayOfMonth());
        System.out.println("getDayOfWeek -> " + currentTime.getDayOfWeek());
        System.out.println("getDayOfYear -> " + currentTime.getDayOfYear());
        System.out.println("getSecond -> " + currentTime.getSecond());

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2 = " + date2);

        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3 = " + date3);

        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4 = " + date4);

        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);

        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);


        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZonedDateTime now = ZonedDateTime.now(id);
        System.out.println("now = " + now);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }
}
