package oby_na_trzy.crm.resource;

import oby_na_trzy.crm.model.Faktura;
import oby_na_trzy.crm.repository.FakturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/faktura")
public class FakturaResource {

    //@Autowired
    FakturaRepository fakturaRepository;

    @GetMapping(value="/searchbyid/{id}")
    public List<Faktura> doSearchById (@PathVariable("id") int id) {return fakturaRepository.findAllByIdFaktura(id);}

}
