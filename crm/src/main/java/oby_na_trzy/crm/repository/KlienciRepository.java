package oby_na_trzy.crm.repository;

import oby_na_trzy.crm.model.Klienci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

// tu jest interfejs do repozytorium naszej tabeli/klasy
public interface KlienciRepository extends JpaRepository<Klienci, Integer> { // formalność musi być dopełniona
                                  // ten fragment po prostu musi być, tu są podstawowe medody do obługi bazy

    //tutaj możemy ustawić własne zapytanie
    //zmienne wpisujemy po znaku :
    //potem dodajemy je jako parametry @Param
    @Query(value = "SELECT * FROM klienci WHERE pesel = :peselValue", nativeQuery = true)
    List<Klienci> findAllByPesel(@Param("peselValue") String pesel); //to jest nasza metoda szukająca po peselu
    // brak ciała może trochę dziwić, ale pamiętajmy, że wykonało się zapytanie SQL
}
