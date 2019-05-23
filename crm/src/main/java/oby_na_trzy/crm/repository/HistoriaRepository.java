package oby_na_trzy.crm.repository;

import oby_na_trzy.crm.model.Historia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HistoriaRepository extends JpaRepository<Historia, Integer>{

    @Query(value = "SELECT * FROM historia where id_telefonu like :IdTelefonuValue", nativeQuery = true)
    List<Historia> findAllByIdHistoria(@Param("IdTelefonuValue") int IdTelefonu);


    @Query(value = "SELECT * FROM historia where id_telefonu = :IdTelefonuValue and data_polaczenia between \":startData\" and \":koniecData\"", nativeQuery = true)
    List<Historia> findAllByIdAndDateHistoria(@Param("IdTelefonuValue") int IdTelefonu, @Param("startData") LocalDateTime startData, @Param("koniecData") LocalDateTime koniecData);

    @Query(value = "SELECT SUM(cena) FROM historia where id_telefonu = :IdTelefonuValue", nativeQuery = true)
    Float findAllByIdSumHistoria(@Param("IdTelefonuValue") int IdTelefonu);

}
