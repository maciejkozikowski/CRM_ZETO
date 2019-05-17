package oby_na_trzy.crm.resource;

import oby_na_trzy.crm.model.Telefony;
import oby_na_trzy.crm.repository.TelefonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/telefon")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://orfi.uwm.edu.pl")
public class TelefonyResource {

    @Autowired
    TelefonyRepository telefonyRepository;

    @GetMapping(value ="/all")
    public List<Telefony> getAll() {return telefonyRepository.findAll();}

    @GetMapping(value = "/searchbyid/{id}")
    public Optional<Telefony> doSearchById (@PathVariable("id") int id){
        return telefonyRepository.findById(id);
    }

    @GetMapping(value = "/searchbynumer/{numer}")
    public List<Telefony> doSearchByNumer(@PathVariable("numer") String numer) {return telefonyRepository.findAllByNumer(numer);}

    @GetMapping(value = "/searchbyidklienta/{idklienta}")
    public List<Telefony> doSearchByIdKlienta(@PathVariable("idklienta") int IdKlienta) {return telefonyRepository.findAllByIdKlienta(IdKlienta);}

    @DeleteMapping(value = "/delete/{id}")
    public void doDelete(@PathVariable("id") int id){telefonyRepository.deleteById(id);}

    @PostMapping(value = "/add")
    public void doAdd(@RequestBody Telefony telefon){telefonyRepository.save(telefon);}

}
