
package jdk8.api;

import java.util.Calendar;


public class Test {
    public static void main(String[] args) {
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date2.set(2018, Calendar.APRIL, 1);
        
        long start = date1.getTimeInMillis();
        long end = date2.getTimeInMillis();
        long diff = end - start;
        
        final long HOUR = 1000*60*60;
        final long DAY = HOUR * 24;
        
        long diffInDays = diff / DAY;
        
        System.out.println("Days until April Fools: " + diffInDays);
    }
}
