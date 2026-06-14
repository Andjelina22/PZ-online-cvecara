package org.example.service;

import org.example.dao.KorisnikDAO;
import org.example.model.Korisnik;

public class LoginService {

    private KorisnikDAO dao =
            new KorisnikDAO();

    public void registracija(
            Korisnik korisnik){

        dao.dodajKorisnika(korisnik);
    }
}