package org.example.service;

import org.example.dao.PorudzbinaDAO;

public class OrderService {

    private PorudzbinaDAO dao =
            new PorudzbinaDAO();

    public void kreirajPorudzbinu(
            int korisnikId,
            double iznos){

        dao.dodajPorudzbinu(
                korisnikId,
                iznos
        );
    }

    public void promeniStatus(
            int id,
            String status){

        dao.promeniStatus(
                id,
                status
        );
    }
}