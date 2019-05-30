package oby_na_trzy.crm.model;


import javax.persistence.*;

public class Faktura {
    @Id
    @Column(name = "id_klienta")
    private Integer id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "adres_zam")
    private String adres_zam;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "oplata")
    private Float oplata;

    public Faktura(){}

    public Integer getId() { return id; }

    public void setId(Integer id){this.id = id;}

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
}
