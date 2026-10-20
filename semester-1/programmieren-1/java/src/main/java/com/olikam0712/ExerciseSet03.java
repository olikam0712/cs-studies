package com.olikam0712;

/**
 * ExerciseSet03
 * @author Oliver Kaminski
 * @author https://github.com/olikam0712
 * @version 1.0.0
 * Sources used:
 * - Integer Division: https://stackoverflow.com/questions/37795248/integer-division-in-java
 * - Calculating "Schaltjahr": https://www.guter-rat.de/magazin/ratgeber/verbrauchertipps/schaltjahre-berechnen-356
 * - Using JUnit to test the function: https://www.vogella.com/tutorials/JUnit/article.html
 * 
 * TRANSPARENCY NOTICE:
 * - Used Generative AI to generate testcases for the getDayOfTheWeek function to test it thoroughly
 * 
 * Note: Uses helper class "Terminal" provided by professor that simplifies Terminal input
 * Note: Exercise was in german, hence the german language in some parts
 */

public class ExerciseSet03 {
    // Quick demo
    public static void main(String[] args) {
        printName();
        planProject();
        System.out.println("December has had " + getDaysOfMonth(12, 2007) + " days in year 2007");
        System.out.println("The weekday of the Mauerfall was: " + getDayOfTheWeek(9, 11, 1989));
        System.out.println("The weekday of the September 11 incident was: " + getDayOfTheWeek(11, 9, 2001));
        printCalendar(10, 2026);
    }

    /**
     * Exercise: Create a function that prints your name three times into the terminal.
     */
    public static void printName() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Oliver Kaminski");
        }
    }

    /**
     * Exercise: Makie a project planner.
     * - It should get the total number of hours for a project, hourly wage of employees, and amount of them.
     * - Every person works in 8 hour shifts daily.
     * - We have to calculate the total cost of the project and how many working days it would take.
     */
    public static void planProject() {
        int projectHours = Terminal.readInt("Projektumfang (in Arbeitsstunden): ");
        int projectHourRate = Terminal.readInt("Stundensatz (in Euro/h): ");
        int projectWorkers = Terminal.readInt("Verfügbare Mitarbeiter: ");

        int projectCost = projectHours * projectHourRate;
        int projectWorkDays = projectHours / (projectWorkers * 8);
        if (projectHours % (projectWorkers * 8)>0) projectWorkDays += 1;
        
        System.out.println("--------------------------------");
        
        System.out.println("Total Project cost: " + projectCost);
        System.out.println("Project work days: " + projectWorkDays);
    }

    // Helper function to calculate if a year is a "Schaltjahr", which means "leap year"
    public static boolean isSchaltjahr(int year) {
        // Condition 1, divisible by 4, not by 100 => Schaltjahr
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        // Condition 2, divisible by 100, not by 400 => no Schaltjahr
        } else if (year % 100 == 0 && year % 400 != 0) {
            return false;
        // Condition 3, divisible by 400 => Schaltjahr
        } else if (year % 400 == 0) {
            return true;
        }
        return false;
    }

    /**
     * Exercise: Make a function that calculates how many days a month in a certain year has.
     * 
     * @return Returns the number of days or -1 if the provided month and year are invalid
     */
    /* Notes:
        - From month 1 to 7: If month number is odd, it has 31 days, otherwise 30. Excluding Febuary which is dependent on the year
        - From month 8 to 12: If month number is even, it has 31 days, otherwise 30.
        - Feburary has an additional day if the year is a "Schaltjahr"
     */
    public static int getDaysOfMonth(int month, int year) {
        if (month == 2) {
            if (year <= 0) return 0;
            if (isSchaltjahr(year)) return 29;
            return 28;
        } else if (month < 8 && month >= 1) {
            if (month % 2 == 0) return 30;
            return 31;
        } else if (month >= 8 && month <= 12) {
            if (month % 2 == 0) return 31;
            return 30;
        } else return -1;
    }

    /**
     * Exercise: Make a function that computes the week-day number of a given date
     * 
     * @return Number of week-day. Monday being 1 and Sunday being 7
     */
    public static int getDayOfTheWeek(int day, int month, int year) {
        // Convert parameters to ones that are compatible with the formula
        // 1. Convert January and Febuary to 13 and 14 in last year
        if (month <= 2) {
            month+=12;
            year--;
        }

        // 2. Split year into century and decade
        int century = year / 100;
        int decade = year % 100;


        // Apply Zeller's congruence formula
        int dayNumber = day;
        dayNumber += (month + 1) * 13 / 5;
        dayNumber += decade;
        dayNumber += decade / 4;
        dayNumber += century / 4;
        dayNumber += 5 * century; // Applied negative number fix as recommended in the Wikipedia article
        dayNumber %= 7;
        
                
        // Translate week-day numbers and return
        return (dayNumber + 6) % 7 != 0 ? (dayNumber + 6) % 7: 7;
    }

    /**
     * Exercise: Print a formated, calendar like view of a month as shown in the example (Example inside document)
     */
    public static void printCalendar(int month, int year) {
        System.out.println("Mo Tu We Th Fr Sa Su");
        
        int days = getDaysOfMonth(month, year);
        int startingDay = getDayOfTheWeek(1, month, year);

        // Print offset on first row
        int i = 0;
        while (i < startingDay) {
            System.out.print("  ");
            i++;
        }
        System.out.print(" ");

        // Print Days
        i = 1;
        while (i <= days) {
            if (i < 10) {
                System.out.print(" " + i + " ");
            } else System.out.print(i + " ");
            // Add line break
            if ((i + startingDay - 1) % 7 == 0) System.out.println();
            i++;
        }
    }

}