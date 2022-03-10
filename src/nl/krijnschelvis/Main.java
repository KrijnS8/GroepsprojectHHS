package nl.krijnschelvis;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Examen{
    private String soortExamen;
}

class Gebruiker{
    private String name;
    private int studentenNummer;
    private ArrayList<String> examensGehaalt;
    private ArrayList<String> pogingen;

    public Gebruiker(String name, int studentenNummer, ArrayList<String> examensGehaalt, ArrayList<String> pogingen) {
        this.name = name;
        this.studentenNummer = studentenNummer;
        this.examensGehaalt = examensGehaalt;
        this.pogingen = pogingen;
    }
}
