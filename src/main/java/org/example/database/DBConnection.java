package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
//Konekcija sa bazom podataka
public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/cvecara";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {

            System.out.println(
                    "Greška pri povezivanju sa bazom!"
            );

            return null;
        }
    }
}