package org.example.model;

public class Proizvod {

    private int id;
    private String naziv;
    private String opis;
    private double cena;
    private int kolicina;

    public Proizvod() {
    }

    public Proizvod(int id, String naziv, String opis,
                    double cena, int kolicina) {

        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return naziv + " | " + cena + " RSD";
    }
}