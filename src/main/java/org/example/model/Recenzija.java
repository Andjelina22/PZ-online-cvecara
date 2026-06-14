package org.example.model;

public class Recenzija {

    private int id;
    private int ocena;
    private String komentar;

    public Recenzija() {
    }

    public Recenzija(int id, int ocena, String komentar) {
        this.id = id;
        this.ocena = ocena;
        this.komentar = komentar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    @Override
    public String toString() {
        return ocena + "/5 - " + komentar;
    }
}