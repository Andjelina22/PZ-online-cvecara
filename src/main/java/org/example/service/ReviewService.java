package org.example.service;

import org.example.model.Recenzija;

public class ReviewService {

    public void dodajRecenziju(
            Recenzija recenzija){

        System.out.println(
                "Recenzija uspesno dodata!"
        );

        System.out.println(recenzija);
    }
}