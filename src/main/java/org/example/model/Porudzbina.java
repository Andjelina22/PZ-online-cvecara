package org.example.model;

public class Porudzbina {

    private int id;
    private String datum;
    private String status;
    private double ukupanIznos;

    public Porudzbina() {
    }

    public Porudzbina(int id, String datum,
                      String status, double ukupanIznos) {

        this.id = id;
        this.datum = datum;
        this.status = status;
        this.ukupanIznos = ukupanIznos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    @Override
    public String toString() {
        return "Porudzbina #" + id +
                " | " + status +
                " | " + ukupanIznos + " RSD";
    }
}