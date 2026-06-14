package org.example.service;

import org.example.model.Porudzbina;

public class OrderService {

    public void kreirajPorudzbinu(Porudzbina porudzbina){

        System.out.println(
                "Porudzbina uspesno kreirana!"
        );

        System.out.println(porudzbina);
    }

    public void promeniStatus(
            Porudzbina porudzbina,
            String noviStatus){

        porudzbina.setStatus(noviStatus);

        System.out.println(
                "Status promenjen na: "
                        + noviStatus
        );
    }
}