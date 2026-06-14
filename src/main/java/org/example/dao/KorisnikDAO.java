package org.example.dao;

import org.example.database.DBConnection;
import org.example.model.Korisnik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KorisnikDAO {

    public void dodajKorisnika(Korisnik korisnik) {

        String sql =
                "INSERT INTO korisnik(ime, prezime, email, lozinka) VALUES (?, ?, ?, ?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, korisnik.getIme());
            ps.setString(2, korisnik.getPrezime());
            ps.setString(3, korisnik.getEmail());
            ps.setString(4, korisnik.getLozinka());

            ps.executeUpdate();

            System.out.println("Korisnik dodat!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void prikaziSveKorisnike() {

        String sql = "SELECT * FROM korisnik";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("ime") + " | " +
                                rs.getString("prezime") + " | " +
                                rs.getString("email")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void obrisiKorisnika(int id) {

        String sql =
                "DELETE FROM korisnik WHERE id = ?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Korisnik obrisan!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void azurirajEmail(int id,
                              String noviEmail) {

        String sql =
                "UPDATE korisnik SET email = ? WHERE id = ?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, noviEmail);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Email ažuriran!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public boolean login(String email, String lozinka) {

        String sql =
                "SELECT * FROM korisnik WHERE email = ? AND lozinka = ?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, lozinka);

            ResultSet rs =
                    ps.executeQuery();

            return rs.next();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

}