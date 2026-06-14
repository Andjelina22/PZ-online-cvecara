package org.example;

import org.example.model.Proizvod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProizvodTest {

    @Test
    void testCenaProizvoda() {

        Proizvod proizvod =
                new Proizvod(
                        1,
                        "Ruža",
                        "Crvena ruža",
                        500,
                        10
                );

        assertEquals(
                500,
                proizvod.getCena()
        );
    }
}