package oby_na_trzy.crm.repository;

import oby_na_trzy.crm.model.Faktura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FakturaRepository  extends JpaRepository<Faktura, Integer> {

    @Query(value = "select k.imie, k.nazwisko, k.id \"id_klienta\", k.adres_zam, k.pesel, SUM(h.cena) as oplata from klienci k, telefony t, historia h where k.id = t.id_klienta and t.id = h.id_telefonu and k.id=:IdKlientaValue;", nativeQuery = true)
    List<Faktura> findAllByIdFaktura(@Param("IdKlientaValue") int IdKlienta);
}
