package oby_na_trzy.crm.resource;

import oby_na_trzy.crm.model.Klienci;
import oby_na_trzy.crm.repository.KlienciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/klienci")
public class KlienciResource {

    @Autowired
    KlienciRepository klienciRepository;

//    @GetMapping(value = "/all")
    public List<Klienci> getAll() {
        return klienciRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Klienci> persist(@RequestBody final Klienci klienci) {
        klienciRepository.save(klienci);
        return klienciRepository.findAll();
    }



    @GetMapping(value = "/")
    public ModelAndView doHome(){
        return new ModelAndView("index");
    }
    @GetMapping(value = "/all")
    public ModelAndView doView(){

        ModelAndView mv = new ModelAndView("tabela");
        mv.addObject("lists", getAll());
        return mv;
    }

    @GetMapping(value = "/search/{id}")
    public ModelAndView doSearch(@PathVariable("id") int id){

        ModelAndView mv = new ModelAndView("tabela");
        mv.addObject("lists", klienciRepository.findOne(id));
        return mv;
    }
}