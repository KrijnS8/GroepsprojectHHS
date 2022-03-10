package nl.krijnschelvis;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int menu = 1;

    public static void main(String[] args) {
        while (true){
            switch (menu){
                case 0:
                    //exit application
                    break;
                case 1:
                    menu = mainMenu();
                    break;
                case 2:
                    printStudenten();
                    break;
            }
        }
    }

    public static int mainMenu()
    {
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    1) Lijst met examens
                    2) Lijst met studenten
                    3) Nieuwe student inschrijven
                    4) Student verwijderen
                    5) Examen afnemen
                    6) Is student geslaagd voor test?
                    7) Welke examens heeft student gehaald?
                    8) Welke student heeft de meeste examens gehaald?
                    0) Exit
                    Voer een getal in:""");
            try
            {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void printStudenten(){

    }
}