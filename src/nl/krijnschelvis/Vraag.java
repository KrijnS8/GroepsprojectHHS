package nl.krijnschelvis;

class Vraag
{
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