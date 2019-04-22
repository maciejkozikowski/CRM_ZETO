package oby_na_trzy.crm.resource;

import oby_na_trzy.crm.model.Klienci;
import oby_na_trzy.crm.repository.KlienciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// w tej klasie obługujemy CRUD-a
@RestController //nie wiem po co, ale działa
@RequestMapping(value = "/klienci") // znowu, klasa odpala się po wpisaniu takiego adresu
@CrossOrigin(origins = "http://localhost:4200") //pozwalamy apce w angularze komunikować się z backendem
public class KlienciResource{

    @Autowired //też nie wiem, ale działa
    KlienciRepository klienciRepository; //udostępniamy w klasie metody dla tabeli

    @GetMapping(value = "/all")
    // metoda zwraca wszystkie rekordy
    public List<Klienci> getAll() {
        return klienciRepository.findAll();
    }

    @GetMapping(value = "/searchbyid/{id}") //adres "/klienci/searchbyid/" i tu po ukośniku wartość id
    public Klienci doSearchById(@PathVariable("id") int id){
        return klienciRepository.findOne(id);
    }

    @GetMapping(value = "/searchbypesel/{pesel}") //jw
    public List<Klienci> doSearchByPesel(@PathVariable("pesel") String pesel){
        return klienciRepository.findAllByPesel(pesel); // tą metodę dodaliśmy w KlienciRepository
    }

    @DeleteMapping(value = "/delete/{id}")
    public void doDelete(@PathVariable("id") int id){
        klienciRepository.delete(id);
    }

    @PostMapping(value = "/add")
    public void doAdd(@RequestBody Klienci klient){
        klienciRepository.save(klient);
    }
}