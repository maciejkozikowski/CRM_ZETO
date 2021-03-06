package oby_na_trzy.crm.repository;

import oby_na_trzy.crm.model.Telefony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TelefonyRepository extends JpaRepository<Telefony, Integer>{

    @Query(value = "SELECT * FROM telefony where id_klienta like :IdKlientaValue", nativeQuery = true)
    List<Telefony> findAllByIdKlienta(@Param("IdKlientaValue") int IdKlienta);

    @Query(value = "SELECT * FROM telefony where numer like :NumerTel", nativeQuery = true)
    List<Telefony> findAllByNumer(@Param("NumerTel") String numer);

}
