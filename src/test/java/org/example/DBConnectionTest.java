package org.example;

import org.example.database.DBConnection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Dodati JUnit testovi
public class DBConnectionTest {

    @Test
    void testKonekcija() {

        assertNotNull(
                DBConnection.getConnection()
        );
    }
}