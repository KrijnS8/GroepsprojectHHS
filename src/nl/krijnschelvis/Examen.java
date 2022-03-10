package nl.krijnschelvis;

import java.util.ArrayList;

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