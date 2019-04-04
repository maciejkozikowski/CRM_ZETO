package oby_na_trzy.crm.model;

import javax.persistence.*;

@Entity
@Table(name = "klienci")
public class Klienci {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "adres_zam")
    private String adres_zam;

    @Column(name = "adres_kon")
    private String adres_kon;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "email")
    private String email;

    public Klienci() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAdres_zam() {
        return adres_zam;
    }

    public void setAdres_zam(String adres_zam) {
        this.adres_zam = adres_zam;
    }

    public String getAdres_kon() {
        return adres_kon;
    }

    public void setAdres_kon(String adres_kon) {
        this.adres_kon = adres_kon;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
