package com.sunlight001.test.datet;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Calendar;

public class DateTimeTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));    // 0 - 11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));

        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());     // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
        
        
        Calendar.getInstance().getTimeInMillis();
        System.currentTimeMillis();
        Clock.systemDefaultZone().millis(); // Java 8
        
        Calendar time = Calendar.getInstance();
        time.getActualMaximum(Calendar.DAY_OF_MONTH);


    }
}

