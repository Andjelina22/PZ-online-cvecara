package org.example;

import org.example.model.Porudzbina;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PorudzbinaTest {

    @Test
    void testStatusPorudzbine() {

        Porudzbina porudzbina =
                new Porudzbina(
                        1,
                        "2025-06-14",
                        "Na čekanju",
                        1500
                );

        assertEquals(
                "Na čekanju",
                porudzbina.getStatus()
        );
    }
}