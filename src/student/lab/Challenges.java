
package student.lab;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Challenges {
    public static void main(String[] args) {
        //next Friday the 13th
        
        LocalDate now = LocalDate.now();
        while(now.getDayOfMonth() != 13){
            now = now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        
        System.out.println(now);
        
        //day of the week Christmast falls on
        
        LocalDate christmas = LocalDate.of(2017, Month.DECEMBER, 25);
        System.out.println(christmas.getDayOfWeek());
    }
}
