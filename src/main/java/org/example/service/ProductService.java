package org.example.service;

import org.example.dao.ProizvodDAO;
import org.example.model.Proizvod;

//Servis za rad sa proizvodima

public class ProductService {

    private ProizvodDAO proizvodDAO =
            new ProizvodDAO();

    public void dodajProizvod(Proizvod proizvod) {

        if(proizvod.getCena() <= 0){

            System.out.println("Cena mora biti veca od 0!");
            return;
        }

        proizvodDAO.dodajProizvod(proizvod);
    }

    public void prikaziProizvode() {

        proizvodDAO.prikaziSveProizvode();
    }
}