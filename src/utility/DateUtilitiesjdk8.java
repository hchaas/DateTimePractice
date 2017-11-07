package utility;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtilitiesjdk8 {

    public static void main(String[] args) {
        DateUtilitiesjdk8 sample = new DateUtilitiesjdk8();
        LocalDate today = LocalDate.now();
        String dateString = "10/31/17";
        //sample.convertDateToStringDefault(today);
        //sample.findDatePlusXWeeks(today, 4);

    }

    /*this method converts a date object to a string using a default format; does not allow user input for format*/
    public void convertDateToStringDefault(LocalDate today) throws IllegalArgumentException {
        if (today == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy");
        String strDate = today.format(format);
        System.out.println("Date with default formatting: " + strDate);

    }

    /*this method converts a date object to a string using a format that the user passes in*/
    public void convertDateToStringCustom(LocalDate date, String formatString) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        if (formatString.contains("h") || formatString.contains("s")) {
            throw new IllegalArgumentException("Format string invalid; simple format does not contain"
                    + "hours or seconds.");
        }
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(formatString);
            String strDate = date.format(format);
            System.out.println("Date with user-defined format: " + strDate);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Format string invalid.");
        }
    }

    /*this method converts a string to a date with a default format*/
    public void convertStringToDateTimeSimple(String stringDate) throws IllegalArgumentException {
        if (stringDate == null || stringDate.isEmpty()) {
            throw new IllegalArgumentException("Date cannot be empty or null.");
        }
        try {
            LocalDate date = LocalDate.parse(stringDate);
            System.out.println(date);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Date cannot be parsed.");
        }

    }

    /*this method converts a string to a date with a defined format */
    public void convertStringToDateTimeCustomFormat(String stringDate, String formatString) throws IllegalArgumentException {
        if (stringDate == null || stringDate.isEmpty()) {
            throw new IllegalArgumentException("Date cannot be empty or null.");
        }
        if (formatString.contains("h") || formatString.contains("s")) {
            throw new IllegalArgumentException("Format string invalid; simple format does not contain"
                    + "hours or seconds.");
        }
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(formatString);
            LocalDate date = LocalDate.parse(stringDate, format);
            System.out.println(date);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Date format cannot be parsed.");
        }
    }

    /*this method finds the difference between today and a significant date, as defined by the user*/
    public void countdownToSignificantDay(LocalDate date, String significantDateName) throws IllegalArgumentException {

        if (date == null){
            throw new IllegalArgumentException("Date cannot be null.");
        }
        if(significantDateName == null || significantDateName.isEmpty()){
            throw new IllegalArgumentException("Significant date name cannot be null or empty.");
        }
        
        LocalDate today = LocalDate.now();
        Duration dayDifference = Duration.between(today, date);
        System.out.println("There are " + dayDifference.toDays() + " days until " + significantDateName);
        
    }
    
    /*this method finds the value of a date plus x number of weeks, as defined by the user */
    public void findDatePlusXWeeks(LocalDate date, int variableWeeks) throws IllegalArgumentException{
        if (date == null){
            throw new IllegalArgumentException("Date cannot be null.");
        }
        
        System.out.println(variableWeeks + " weeks from " + date + " will be " + date.plus(variableWeeks, ChronoUnit.WEEKS));
        
        
    }
}
