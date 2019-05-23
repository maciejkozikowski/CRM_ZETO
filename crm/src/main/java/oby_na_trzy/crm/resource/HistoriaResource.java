package oby_na_trzy.crm.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import oby_na_trzy.crm.model.Historia;
import oby_na_trzy.crm.repository.HistoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping(value="/searchbyidanddate/{id},{startdata},{koniecdata}")
    public List<Historia> doSearchByIdAndDate (@PathVariable("id") int id, @PathVariable("startdata") LocalDateTime startdata, @PathVariable("koniecdata") LocalDateTime koniecdata){return historiaRepository.findAllByIdAndDateHistoria(id, startdata, koniecdata);}

    @GetMapping(value = "searchbyidsum/{id}")
    public Float doSearchByIdSum (@PathVariable("id") int id){return historiaRepository.findAllByIdSumHistoria(id);}

    @GetMapping(value = "searchbyphoneid/{phoneid}")
    public List<Historia> findAllByIdHistoria(@PathVariable("phoneid") int IdTelefonu){return historiaRepository.findAllByIdHistoria(IdTelefonu);}

}
