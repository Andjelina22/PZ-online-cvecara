package org.example.service;

import org.example.dao.RecenzijaDAO;
import org.example.model.Recenzija;

public class ReviewService {

    private RecenzijaDAO recenzijaDAO =
            new RecenzijaDAO();

    public void dodajRecenziju(
            Recenzija recenzija){

        recenzijaDAO.dodajRecenziju(
                recenzija
        );
    }
}