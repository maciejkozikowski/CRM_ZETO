package oby_na_trzy.crm.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Faktura {

    private String imie;

    private String nazwisko;

    private String adres_zam;

    private String pesel;

    private Float oplata;

    private ArrayList<String> telefony;

    private ArrayList<Float> oplaty;
    public Faktura(){}

    public String getImie(){return imie;}

    public void setImie(String imie){this.imie = imie;}

    public String getNazwisko(){return nazwisko;}

    public void setNazwisko(String nazwisko){this.nazwisko = nazwisko;}

    public String getAdres_zam(){return adres_zam;}

    public void setAdres_zam(String adres_zam){this.adres_zam = adres_zam;}

    public String getPesel(){return pesel;}

    public void setPesel(String pesel){this.pesel = pesel;}

    public Float getOplata(){return oplata;}

    public void setOplata(Float oplata){this.oplata = oplata;}

    public ArrayList<String> getTelefony() {
        return telefony;
    }

    public void setTelefony(ArrayList<String> telefony) {
        this.telefony = telefony;
    }

    public ArrayList<Float> getOplaty() {
        return oplaty;
    }

    public void setOplaty(ArrayList<Float> oplaty) {
        this.oplaty = oplaty;
    }
}
