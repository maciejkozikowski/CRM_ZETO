package oby_na_trzy.crm.resource;

import oby_na_trzy.crm.model.Telefony;
import oby_na_trzy.crm.repository.TelefonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/telefon")
@CrossOrigin(origins = "http://localhost:4200")

public class TelefonyResource {

    @Autowired
    TelefonyRepository telefonyRepository;

    @GetMapping(value ="/all")
    public List<Telefony> getAll() {return telefonyRepository.findAll();}

    @GetMapping(value = "/searchbynumer/{numer}")
    public Telefony doSearchByNumer(@PathVariable("numer") String numer) {return telefonyRepository.findOne(numer);}

    @GetMapping(value = "/searchbyidklienta/{idklienta}")
    public List<Telefony> doSearchByIdKlienta(@PathVariable("IdKlienta") int IdKlienta) {return telefonyRepository.findAllByIdKlienta(IdKlienta);}

    @DeleteMapping(value = "/delete/{numer}")
    public void doDelete(@PathVariable("numer") String numer){telefonyRepository.delete(numer);}

    @PostMapping(value = "/add")
    public void doAdd(@RequestBody Telefony telefon){telefonyRepository.save(telefon);}

}
