package oby_na_trzy.crm.repository;

import oby_na_trzy.crm.model.Historia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoriaRepository extends JpaRepository<Historia, Integer>{

    @Query(value = "SELECT * FROM historia where id like :IdTelefonuValue", nativeQuery = true)
    List<Historia> findAllByIdHistoria(@Param("IdTelefonuValue") int IdTelefonu);


}
