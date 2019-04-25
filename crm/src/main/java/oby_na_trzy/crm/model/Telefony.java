package oby_na_trzy.crm.model;

import javax.persistence.*;
@Entity
@Table(name = "telefony")
public class Telefony {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    //@Id //pole numer jest identyfikatorem w tabeli
    @Column(name = "numer") //pole odpowiada kolumnie numer w tabeli
    private String numer;

    @Column(name = "postpaid")//pole odpowiada kolumnie pospaid w tabeli
    private boolean postpaid;

    @Column(name = "stan_konta")
    private float stan_konta;

    @Column(name = "darmowe_rozmowy")
    private boolean darmowe_rozmowy;

    @Column(name = "darmowe_smsy")
    private boolean darmowe_smsy;

    @Column(name = "darmowy_internet")
    private boolean darmowy_internet;

    @Column(name = "id_klienta")
    private int id_klienta;

    public Telefony() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNumer() {return numer;}

    public void setNumer(String numer) {this.numer = numer;}

    public boolean getPostpaid(){return postpaid;}

    public void setPostpaid(boolean postpaid) {this.postpaid = postpaid;}

    public float getStan_konta(){return stan_konta;};

    public void setStan_konta(float stan_konta){this.stan_konta = stan_konta;}

    public boolean getDarmowe_rozmowy(){return darmowe_rozmowy;}

    public void setDarmowe_rozmowy(boolean darmowe_rozmowy){this.darmowe_rozmowy = darmowe_rozmowy;}

    public boolean getDarmowe_smsy(){return darmowe_smsy;}

    public void setDarmowe_smsy(boolean darmowe_smsy){this.darmowe_smsy = darmowe_smsy;}

    public boolean getDarmowy_internet(){return darmowy_internet;}

    public void setDarmowy_internet(boolean darmowy_internet){this.darmowy_internet = darmowy_internet;}

    public int getId_klienta() { return id_klienta; }

    public void setId_klienta(int id_klienta) { this.id_klienta = id_klienta; }
}
