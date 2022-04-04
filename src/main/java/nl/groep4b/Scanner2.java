package nl.groep4b;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Scanner2 {
    /**
     * This class implements a replacement for the normal Scanner class with errors taken care of
     */

    //Variables:
    Scanner scanner = new Scanner(System.in);

    //Methods:
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
