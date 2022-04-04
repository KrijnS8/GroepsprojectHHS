package nl.groep4b;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Scanner2 {
    //Implements another function for scanner using scanner to allow the program to continue running smoothly
    // when wrong inputs are given
    Scanner scanner = new Scanner(System.in);

    public String nextLine(){
        String result;
        try {
            result = scanner.nextLine();
        }
        catch (InputMismatchException exception) {
            scanner.nextLine();
            System.out.println("Geef een goed antwoord");
            return nextLine();
        }
        return result;
    }

    public int nextInt(){
        int result;
        try {
            result = scanner.nextInt();
            scanner.nextLine();
        }
        catch (InputMismatchException exception) {
            scanner.nextLine();
            System.out.println("Geef enkel een getal als antwoord");
            return nextInt();
        }
        return result;
    }

    public boolean nextBoolean() {
        boolean result;
        try {
            result = scanner.nextBoolean();
            scanner.nextLine();
        }
        catch (InputMismatchException exception) {
            scanner.nextLine();
            System.out.println("Antwoord met true voor ja en met false voor nee");
            return nextBoolean();
        }
        return result;
    }
}
