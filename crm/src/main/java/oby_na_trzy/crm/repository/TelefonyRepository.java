package oby_na_trzy.crm.repository;

import oby_na_trzy.crm.model.Telefony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TelefonyRepository extends JpaRepository<Telefony, Integer>{

    @Query(value = "SELECT * FROM telefony where IdKlienta like :IdKlientaValue", nativeQuery = true)
    List<Telefony> findAllByIdKlienta(@Param("IdKlientaValue") int IdKlienta);

    Telefony findOne(String numer);

    void delete(String numer);
}
