
package utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtilitiesjdk8 {
    public static void main(String[] args) {
        DateUtilitiesjdk8 sample = new DateUtilitiesjdk8();
        LocalDate today = LocalDate.now();
        sample.convertDateToStringDefault(today);
        
    }
    
    /*this method converts a date object to a string using a default format; does not allow user input for format*/
    public void convertDateToStringDefault(LocalDate today) throws IllegalArgumentException{
        if (today == null){
            throw new IllegalArgumentException("Date cannot be null.");
        }
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy");
        String strDate = today.format(format);
        System.out.println("Date with default formatting: " + strDate);
        
    }
    
    /*this method converts a date object to a string using a format that the user passes in*/
    public void convertDateToStringCustom(LocalDate date, String formatString) throws IllegalArgumentException{
        if (date == null){
            throw new IllegalArgumentException("Date cannot be null.");
        }
        if (formatString.contains("h") || formatString.contains("s")){
            throw new IllegalArgumentException("Format string invalid; simple format does not contain"
                    + "hours or seconds.");
        }
        try{
        DateTimeFormatter format = DateTimeFormatter.ofPattern(formatString);
        String strDate = date.format(format);
        System.out.println("Date with user-defined format: " + strDate);
        }
        catch (IllegalArgumentException iae){
            throw new IllegalArgumentException("Format string invalid.");
        }
    }
    
    /*two methods to convert string to date/time objects*/
    public void convertStringToDateTimeSimple(String stringDate) throws IllegalArgumentException{
        if (stringDate == null || stringDate.isEmpty()){
            throw new IllegalArgumentException("Date cannot be empty or null.");
        }
        try{
        LocalDate date = LocalDate.parse(stringDate);
        System.out.println(date);
        }
        catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Date cannot be parsed.");
        }
        
    }
    
    public void convertStringToDateTimeDetailed(String stringDate) throws IllegalArgumentException{
        if (stringDate == null || stringDate.isEmpty()){
            throw new IllegalArgumentException("Date cannot be empty or null.");
        }
        try{
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy");
            LocalDate date = LocalDate.parse(stringDate, format);
            System.out.println(date);
        }
        catch (IllegalArgumentException iae){
            throw new IllegalArgumentException("Date cannot be parsed.");
        }
    }
    
    /*date/time arithmetic to find difference between two dates*/
}
