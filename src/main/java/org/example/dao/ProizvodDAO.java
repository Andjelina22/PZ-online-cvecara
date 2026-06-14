package org.example.dao;

import org.example.database.DBConnection;
import org.example.model.Proizvod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProizvodDAO {

    public void dodajProizvod(Proizvod proizvod) {

        String sql =
                "INSERT INTO proizvod(naziv,opis,cena,kolicina) VALUES (?,?,?,?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, proizvod.getNaziv());
            ps.setString(2, proizvod.getOpis());
            ps.setDouble(3, proizvod.getCena());
            ps.setInt(4, proizvod.getKolicina());

            ps.executeUpdate();

            System.out.println("Proizvod dodat!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void prikaziSveProizvode() {

        String sql =
                "SELECT * FROM proizvod";

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
                                rs.getString("naziv") + " | " +
                                rs.getDouble("cena")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void obrisiProizvod(int id){

        String sql =
                "DELETE FROM proizvod WHERE id=?";

        try{

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();

            System.out.println(
                    "Proizvod obrisan!"
            );

        }catch(Exception e){

            e.printStackTrace();
        }
    }

    public Proizvod pronadjiPoId(int id) {

        String sql =
                "SELECT * FROM proizvod WHERE id = ?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                return new Proizvod(
                        rs.getInt("id"),
                        rs.getString("naziv"),
                        rs.getString("opis"),
                        rs.getDouble("cena"),
                        rs.getInt("kolicina")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}