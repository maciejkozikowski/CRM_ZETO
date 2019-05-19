package oby_na_trzy.crm.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historia")
public class Historia {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_polaczenia")
    private LocalDateTime data_polaczenia;

    @Column(name = "rodzaj")
    private Integer rodzaj;

    @Column(name = "nr_docelowy")
    private String nr_docelowy;

    @Column(name = "rozmiar")
    private Integer rozmiar;

    @Column(name = "cena")
    private Float cena;

    public Historia(){}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public LocalDateTime getData_polaczenia(){return data_polaczenia;}

    public void setData_polaczenia(LocalDateTime data_polaczenia){this.data_polaczenia = data_polaczenia;}

    public Integer getRodzaj(){return rodzaj;}

    public void setRodzaj(Integer rodzaj){this.rodzaj = rodzaj;}

    public String getNr_docelowy(){return nr_docelowy;}

    public void setNr_docelowy(String nr_docelowy) {this.nr_docelowy = nr_docelowy;}

    public Integer getRozmiar(){return rozmiar;}

    public void setRozmiar(Integer rozmiar) {this.rozmiar = rozmiar;}

    public Float getCena(){return cena;}

    public void setCena(Float cena){this.cena = cena;}
}
