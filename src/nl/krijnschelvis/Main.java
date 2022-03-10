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

    public static void printStudenten(){

    }

    public static int mainMenu()
    {
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1) Lijst met examens\n" +
                    "2) Lijst met studenten\n" +
                    "3) Nieuwe student inschrijven\n" +
                    "4) Student verwijderen\n" +
                    "5) Examen afnemen\n" +
                    "6) Is student geslaagd voor test?\n" +
                    "7) Welke examens heeft student gehaald?\n" +
                    "8) Welke student heeft de meeste examens gehaald?\n" +
                    "0) Exit\n" +
                    "Voer een getal in:");
            try
            {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
        }
    }
}



class Examen{
    private String soortExamen, naam;
    private double normering;
    private ArrayList<Vraag> vragen = new ArrayList<>();

    public Examen(String soortExamen, String naam, double normering, ArrayList<Vraag> vragen)
    {
        this.soortExamen = soortExamen;
        this.naam = naam;
        this.normering = normering;
        this.vragen = vragen;
    }
}

class Vraag{
    private String soortVraag, vraag, antwoord;
    private int gewicht;

    public Vraag(String soortVraag, String vraag, String antwoord, int gewicht)
    {
        this.soortVraag = soortVraag;
        this.vraag = vraag;
        this.antwoord = antwoord;
        this.gewicht = gewicht;
    }
}