package org.example.dao;

import org.example.database.DBConnection;
import org.example.model.Recenzija;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RecenzijaDAO {

    public void dodajRecenziju(Recenzija recenzija) {

        String sql =
                "INSERT INTO recenzija(proizvod_id, ocena, komentar) VALUES (?, ?, ?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, recenzija.getProizvodId());
            ps.setInt(2, recenzija.getOcena());
            ps.setString(3, recenzija.getKomentar());

            ps.executeUpdate();

            System.out.println("Recenzija uspešno sačuvana!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}