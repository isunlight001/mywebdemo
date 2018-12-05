package com.sunlight001.test.datet;

import java.time.LocalDateTime;
import java.util.Calendar;

public class YesterdayCurrent {
	public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());
        
        //java8
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);

        System.out.println(yesterday);

    }

}
