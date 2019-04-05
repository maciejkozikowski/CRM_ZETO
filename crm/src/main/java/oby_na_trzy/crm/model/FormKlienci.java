package oby_na_trzy.crm.model;

// zwykła klasa dla formularza dodawania/modyfikowania klienta
public class FormKlienci {
    //pola naszego formularza
    private String imie;
    private String nazwisko;
    private String pesel;
    private String adres_zam;
    private String adres_kon;
    private String telefon;
    private String email;

    //tworzymy gettery, settery i konstruktor
    //w IntelliJ możemy zrobić to automatycznie
    //Klikamy "prawy z myszy" i wybieramy Generate
    //Contructor -> select none - utworzy sie pusty konstruktor (jeśli jest potrzeba ustawiania pól można je wybrać)
    //Getter and Setter -> wybieramy wszystko

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

    public FormKlienci(){ }

    //ta metoda służy zamianie obiektu formularza na obiekt encji(rekordu) do tabeli
    public Klienci formToKlient(){
        //tworzymy nowy obiekt encji
        Klienci klient = new Klienci();
        //ustawiamy wszystkie pola (oprócz id - o tym w klasie Klienci)
        klient.setImie(getImie());
        klient.setNazwisko(getNazwisko());
        klient.setPesel(getPesel());
        klient.setAdres_zam(getAdres_zam());
        klient.setAdres_kon(getAdres_kon());
        klient.setTelefon(getTelefon());
        klient.setEmail(getEmail());
        return klient; //zwracamy naszą encję
    }
}
