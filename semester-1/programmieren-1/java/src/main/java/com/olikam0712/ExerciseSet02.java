package com.olikam0712;

/**
 * ExerciseSet02
 * @author Oliver Kaminski
 * @author https://github.com/olikam0712
 * @version 1.0.0
 * Sources used:
 * - Documentation on how to use JavaDoc: https://www.jetbrains.com/help/idea/javadocs.html#write-javadocs
 * - The rest has been done by memory or trial and error.
 * 
 * Note: Uses helper class "Terminal" provided by professor that simplifies Terminal input
 * Note: Exercise was in german, hence the german language in some parts
 */
public class ExerciseSet02 {
    // Demo
    public static void main(String[] args) {
        int num = Terminal.readInt("Provide a number");
        System.out.println("Sum: " + computeSum(num));
        printSequence1(num);
        printSequence2(num);
        printSequence3(num);
        printTriangle(num);
    }


    /**
     * Given method from Example in exercise sheet
     */
    public static int computeSum(int number) {
        int result = 0; int i = 1;
        while (i <= number) {
            result = result + i; i = i + 1;
        }
        return result;
    }

    /**
     * Exercise: Create this sequence: 0 1 4 9 16 25 36 49 64 81 100 121 ...
     * 
     * @param count Count of elements of the sequence
     */
    public static void printSequence1(int count) {
        System.out.print("Sequence 1:");
        int number = 0;
        for (int i = 0; i < count; i++) {
            System.out.print(" " + number);
            number += 1+i*2;
        }
        System.out.print("\n");
    }

    /**
     * Exercise: Create this sequence: 1 -2 3 -4 5 -6 7 -8 9 -10 11 -12 ...
     * 
     * @param count Count of elements of the sequence
     */
    public static void printSequence2(int count) {
        System.out.print("Sequence 2:");
        for (int i = 1; i <= count; i++) {
            if (i%2 != 0) {
                System.out.print(" " + i);
            } else {
                System.out.print(" -" + i);
            }
        }
        System.out.print("\n");
    }

    /**
     * Exercise: Create this sequence: 1 3 6 10 15 21 28 36 45 55 66 78 ...
     * 
     * @param count Count of elements of the sequence
     */
    public static void printSequence3(int count) {
        System.out.print("Triangular numbers:");
        int current = 1;
        for (int i = 2; i < count+2; i++) {
            System.out.print(" " + current);
            current+=i;
        }
        System.out.print("\n");
    }

    /**
     * Exercise: Visualize the given triangular number
     * 
     * @param n Count of elements of the sequence.
     */
    public static void printTriangle(int n) {
        System.out.println("Visualization of the " + n + "-th triangular number:");
        for (int i = 1; i < n+1; i++) {
            System.out.println(".".repeat(i));
        }
    }

}

