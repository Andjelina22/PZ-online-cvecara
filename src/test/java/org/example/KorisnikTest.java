package org.example;

import org.example.model.Korisnik;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KorisnikTest {

    @Test
    void testKorisnikEmail() {

        Korisnik korisnik =
                new Korisnik(
                        1,
                        "Anđelina",
                        "Stojković",
                        "andja@gmail.com",
                        "123456"
                );

        assertEquals(
                "andja@gmail.com",
                korisnik.getEmail()
        );
    }
}