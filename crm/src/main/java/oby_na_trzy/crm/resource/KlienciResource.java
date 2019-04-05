package oby_na_trzy.crm.resource;

import oby_na_trzy.crm.model.FormKlienci;
import oby_na_trzy.crm.model.Klienci;
import oby_na_trzy.crm.repository.KlienciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@RequestMapping(value = "/klienci")
public class KlienciResource {

    @Autowired
    KlienciRepository klienciRepository;

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

    @GetMapping(value = "/searchbyid/{id}")
    public ModelAndView doSearchById(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("tabela");
        mv.addObject("lists", klienciRepository.findOne(id));
        return mv;
    }

    @GetMapping(value = "/searchbypesel/{pesel}")
    public ModelAndView doSearchByPesel(@PathVariable("pesel") String pesel){
        ModelAndView mv = new ModelAndView("tabela");
        mv.addObject("lists", klienciRepository.findAllByPesel(pesel));
        return mv;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView doDelete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("redirect:/klienci/all");
        klienciRepository.delete(id);
        return mv;
    }

    @PostMapping(value = "/add")
    public ModelAndView doAdd(@ModelAttribute(name="formKlienci") FormKlienci klient, Model model) {
        ModelAndView mv = new ModelAndView("redirect:/klienci/all");
        model.addAttribute("formKlienci", klient);
        Klienci nowyKlient = klient.formToKlient();
        klienciRepository.save(nowyKlient);
        return mv;
    }
}