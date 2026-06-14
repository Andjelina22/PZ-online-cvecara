package org.example.dao;

import org.example.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//DAO klasa za upravljanje porudzbinama

public class PorudzbinaDAO {

    public void dodajPorudzbinu(
            int korisnikId,
            double iznos){

        String sql =
                "INSERT INTO porudzbina(korisnik_id,datum,status,ukupan_iznos) VALUES (?,CURDATE(),?,?)";

        try{

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, korisnikId);
            ps.setString(2, "U obradi");
            ps.setDouble(3, iznos);

            ps.executeUpdate();

            System.out.println(
                    "Porudzbina kreirana!"
            );

        }catch(Exception e){

            e.printStackTrace();
        }
    }

    public void prikaziSvePorudzbine() {

        String sql =
                "SELECT * FROM porudzbina";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getInt("korisnik_id") + " | " +
                                rs.getString("status") + " | " +
                                rs.getDouble("ukupan_iznos")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public void promeniStatus(
            int id,
            String status){

        String sql =
                "UPDATE porudzbina SET status=? WHERE id=?";

        try{

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1,status);
            ps.setInt(2,id);

            ps.executeUpdate();

            System.out.println(
                    "Status promenjen!"
            );

        }catch(Exception e){

            e.printStackTrace();
        }
    }
}