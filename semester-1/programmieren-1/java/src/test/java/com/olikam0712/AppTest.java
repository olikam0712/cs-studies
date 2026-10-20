package com.olikam0712;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests
 * @author Oliver Kaminski
 * @author https://github.com/olikam0712
 */
public class AppTest 
{

    /*
        Test cases for exercises in ExerciseSet03
    */
    @Test
    public void testDayOfTheWeek() {
        assertEquals(ExerciseSet03.getDayOfTheWeek(9, 11, 1989), 4);
        assertEquals(ExerciseSet03.getDayOfTheWeek(11, 9, 2001), 2);
    }

    /**
     * IMPORTANT Transparency Notice: AI-Generated!
     */
    @Test
    public void testDayOfTheWeekAIGenerated() {
        // --- 1. Bekannte historische Daten (ISO: 1=Mo, 2=Di, 3=Mi, 4=Do, 5=Fr, 6=Sa, 7=So) ---
        
        // 09.11.1989 (Donnerstag = 4)
        assertEquals(4, ExerciseSet03.getDayOfTheWeek(9, 11, 1989));

        // 11.09.2001 (Dienstag = 2)
        assertEquals(2, ExerciseSet03.getDayOfTheWeek(11, 9, 2001));

        // 01.01.2000 (Samstag = 6)
        assertEquals(6, ExerciseSet03.getDayOfTheWeek(1, 1, 2000));


        // --- 2. Monats- und Jahreswechsel ---
        
        // 31.12.1999 (Freitag = 5)
        assertEquals(5, ExerciseSet03.getDayOfTheWeek(31, 12, 1999));

        // Jahreswechsel von 1999 auf 2000 (01.01.2000 ist Samstag = 6)
        assertEquals(6, ExerciseSet03.getDayOfTheWeek(1, 1, 2000));


        // --- 3. Schaltjahr-Tests (Februar mit 29 Tagen) ---
        
        // 28.02.2000 (Montag = 1)
        assertEquals(1, ExerciseSet03.getDayOfTheWeek(28, 2, 2000));

        // 29.02.2000 (Dienstag = 2 - Schalttag)
        assertEquals(2, ExerciseSet03.getDayOfTheWeek(29, 2, 2000));

        // 01.03.2000 (Mittwoch = 3)
        assertEquals(3, ExerciseSet03.getDayOfTheWeek(1, 3, 2000));


        // --- 4. Kein Schaltjahr (Vergleichsjahr 2001) ---
        
        // 28.02.2001 (Mittwoch = 3)
        assertEquals(3, ExerciseSet03.getDayOfTheWeek(28, 2, 2001));
        
        // 01.03.2001 (Donnerstag = 4, springt direkt vom 28. Februar zum 1. März)
        assertEquals(4, ExerciseSet03.getDayOfTheWeek(1, 3, 2001));


        // --- 5. Monatsenden (30 und 31 Tage) ---
        
        // 30.04.2023 (Sonntag = 7)
        assertEquals(7, ExerciseSet03.getDayOfTheWeek(30, 4, 2023));
        
        // 01.05.2023 (Montag = 1)
        assertEquals(1, ExerciseSet03.getDayOfTheWeek(1, 5, 2023));
    }
}
