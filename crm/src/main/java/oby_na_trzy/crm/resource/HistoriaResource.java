package oby_na_trzy.crm.resource;

import oby_na_trzy.crm.model.Historia;
import oby_na_trzy.crm.repository.HistoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/historia")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://orfi.uwm.edu.pl")
public class HistoriaResource {

    @Autowired
    HistoriaRepository historiaRepository;

    @GetMapping(value ="/searchbyid/{id}")
    public Optional<Historia> doSearchById (@PathVariable("id") int id) { return historiaRepository.findById(id); }



}
