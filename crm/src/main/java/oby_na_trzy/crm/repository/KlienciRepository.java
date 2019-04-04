package oby_na_trzy.crm.repository;

import oby_na_trzy.crm.model.Klienci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KlienciRepository extends JpaRepository<Klienci, Integer> {


    @Query(value = "SELECT * FROM klienci WHERE pesel = :peselValue",
            nativeQuery = true)
    List<Klienci> findAllByPesel(@Param("peselValue") String pesel);

}
