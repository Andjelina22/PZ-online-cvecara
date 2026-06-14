package org.example.main;

import org.example.dao.KorisnikDAO;
import org.example.dao.PorudzbinaDAO;
import org.example.dao.ProizvodDAO;
import org.example.model.Korisnik;
import org.example.model.Proizvod;
import org.example.model.Recenzija;
import org.example.service.ReviewService;

import java.util.Scanner;
//UML dijagram dodat u dokumentaciju
//ER dijagram dodat u dokumentaciju
//Ažurirana projektna dokumentacija
//Završna verzija projekta

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        KorisnikDAO korisnikDAO = new KorisnikDAO();
        ProizvodDAO proizvodDAO = new ProizvodDAO();
        PorudzbinaDAO porudzbinaDAO = new PorudzbinaDAO();
        ReviewService reviewService = new ReviewService();

        int izbor;

        do {

            System.out.println("\n================================");
            System.out.println("      ONLINE CVECARA");
            System.out.println("================================");
            System.out.println("1. Registracija");
            System.out.println("2. Prijava");

            System.out.println("\n----- KUPAC -----");
            System.out.println("3. Pregled proizvoda");
            System.out.println("4. Kreiraj porudzbinu");
            System.out.println("5. Dodaj recenziju");

            System.out.println("\n----- ADMIN -----");
            System.out.println("6. Dodaj proizvod");
            System.out.println("7. Obrisi proizvod");
            System.out.println("8. Prikazi korisnike");
            System.out.println("9. Prikazi porudzbine");
            System.out.println("10. Promeni status porudzbine");

            System.out.println("\n0. Izlaz");

            System.out.print("\nIzbor: ");
            izbor = sc.nextInt();
            sc.nextLine();

            switch (izbor) {

                case 1: {

                    System.out.print("Ime: ");
                    String ime = sc.nextLine();

                    System.out.print("Prezime: ");
                    String prezime = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Lozinka: ");
                    String lozinka = sc.nextLine();

                    Korisnik korisnik = new Korisnik(
                            0,
                            ime,
                            prezime,
                            email,
                            lozinka
                    );

                    korisnikDAO.dodajKorisnika(korisnik);

                    break;
                }

                case 2: {

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Lozinka: ");
                    String lozinka = sc.nextLine();

                    if (korisnikDAO.login(email, lozinka)) {
                        System.out.println("Uspesna prijava!");
                    } else {
                        System.out.println("Pogresan email ili lozinka!");
                    }

                    break;
                }

                case 3: {

                    proizvodDAO.prikaziSveProizvode();

                    break;
                }

                case 4: {

                    proizvodDAO.prikaziSveProizvode();

                    System.out.print("Izaberi ID proizvoda: ");
                    int proizvodId = sc.nextInt();

                    Proizvod izabraniProizvod =
                            proizvodDAO.pronadjiPoId(proizvodId);

                    if (izabraniProizvod == null) {

                        System.out.println("Proizvod ne postoji!");
                        break;
                    }

                    System.out.print("Kolicina: ");
                    int kolicinaPorudzbine = sc.nextInt();

                    double ukupno =
                            izabraniProizvod.getCena()
                                    * kolicinaPorudzbine;

                    System.out.println(
                            "Ukupna cena: "
                                    + ukupno
                                    + " RSD"
                    );

                    System.out.print(
                            "ID korisnika: "
                    );

                    int korisnikId =
                            sc.nextInt();

                    porudzbinaDAO.dodajPorudzbinu(
                            korisnikId,
                            ukupno
                    );

                    break;
                }

                case 5: {

                    System.out.print("Komentar: ");
                    String komentar =
                            sc.nextLine();

                    System.out.print("Ocena (1-5): ");
                    int ocena =
                            sc.nextInt();

                    Recenzija recenzija =
                            new Recenzija(
                                    0,
                                    ocena,
                                    komentar
                            );

                    reviewService
                            .dodajRecenziju(recenzija);

                    break;
                }

                case 6: {

                    System.out.print("Naziv proizvoda: ");
                    String naziv =
                            sc.nextLine();

                    System.out.print("Opis: ");
                    String opis =
                            sc.nextLine();

                    System.out.print("Cena: ");
                    double cena =
                            sc.nextDouble();

                    System.out.print("Kolicina: ");
                    int kolicina =
                            sc.nextInt();

                    Proizvod noviProizvod =
                            new Proizvod(
                                    0,
                                    naziv,
                                    opis,
                                    cena,
                                    kolicina
                            );

                    proizvodDAO
                            .dodajProizvod(noviProizvod);

                    break;
                }

                case 7: {

                    System.out.print(
                            "ID proizvoda za brisanje: "
                    );

                    int id =
                            sc.nextInt();

                    proizvodDAO
                            .obrisiProizvod(id);

                    break;
                }

                case 8: {

                    korisnikDAO
                            .prikaziSveKorisnike();

                    break;
                }

                case 9: {

                    porudzbinaDAO
                            .prikaziSvePorudzbine();

                    break;
                }

                case 10: {

                    System.out.print("ID porudzbine: ");
                    int porudzbinaId = sc.nextInt();

                    System.out.println("\n===== STATUSI =====");
                    System.out.println("1. Potvrdjena");
                    System.out.println("2. U pripremi");
                    System.out.println("3. Spremna za isporuku");
                    System.out.println("4. Poslata");
                    System.out.println("5. Isporucena");
                    System.out.println("6. Otkazana");

                    System.out.print("Izaberite status: ");

                    int statusIzbor = sc.nextInt();

                    String status = "";

                    switch (statusIzbor) {

                        case 1:
                            status = "Potvrdjena";
                            break;

                        case 2:
                            status = "U pripremi";
                            break;

                        case 3:
                            status = "Spremna za isporuku";
                            break;

                        case 4:
                            status = "Poslata";
                            break;

                        case 5:
                            status = "Isporucena";
                            break;

                        case 6:
                            status = "Otkazana";
                            break;

                        default:
                            System.out.println("Pogresan izbor!");
                            break;
                    }

                    if (!status.isEmpty()) {

                        porudzbinaDAO.promeniStatus(
                                porudzbinaId,
                                status
                        );

                        System.out.println(
                                "Novi status: " + status
                        );
                    }

                    break;
                }

                case 0:

                    System.out.println(
                            "Dovidjenja!"
                    );
                    break;

                default:

                    System.out.println(
                            "Pogresan izbor!"
                    );
            }

        } while (izbor != 0);

        sc.close();
    }
}