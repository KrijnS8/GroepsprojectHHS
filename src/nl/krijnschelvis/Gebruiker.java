package nl.krijnschelvis;

import java.util.ArrayList;
import java.util.Scanner;

class Gebruiker{
    private ArrayList<String> examensGehaalt;
    private ArrayList<String> pogingen;
    private String name;
    private int studentenNummer;


    public Gebruiker(String name, int studentenNummer, ArrayList<String> examensGehaalt, ArrayList<String> pogingen) {
        this.name = name;
        this.studentenNummer = studentenNummer;
        this.examensGehaalt = examensGehaalt;
        this.pogingen = pogingen;
    }

    public static void AddStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "1) Vul je gegevens in\n" +
                        "2) Exit");
    }
}