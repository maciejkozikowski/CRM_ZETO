package oby_na_trzy.crm.resource;

import oby_na_trzy.crm.model.FormKlienci;
import oby_na_trzy.crm.model.Klienci;
import oby_na_trzy.crm.repository.KlienciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

// w tej klasie obługujemy CRUD-a
@RestController //nie wiem po co, ale działa
@RequestMapping(value = "/klienci") // znowu, klasa odpala się po wpisaniu takiego adresu
public class KlienciResource {

    @Autowired //też nie wiem, ale działa
    KlienciRepository klienciRepository; //udostępniamy w klasie metody dla tabeli

    // metoda zwraca wszystkie rekordy
    public List<Klienci> getAll() {
        return klienciRepository.findAll();
    }

    // po wpisaniu adresu /klienci/all
    @GetMapping(value = "/all")
    public ModelAndView doView(){
        ModelAndView mv = new ModelAndView("tabela"); //tworzymy widok z pliku tabela.html
        mv.addObject("lists", getAll()); //dodajemy listę rekordów
        return mv; //nasz widok musimy zwrócic
    }

    @GetMapping(value = "/searchbyid/{id}") //adres "/klienci/searchbyid/" i tu po ukośniku wartość id
    public ModelAndView doSearchById(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("tabela");
        mv.addObject("lists", klienciRepository.findOne(id)); // ta medota szuka po id (wbudowana)
        return mv;
    }

    @GetMapping(value = "/searchbypesel/{pesel}") //jw
    public ModelAndView doSearchByPesel(@PathVariable("pesel") String pesel){
        ModelAndView mv = new ModelAndView("tabela");
        mv.addObject("lists", klienciRepository.findAllByPesel(pesel)); // tą metodę dodaliśmy w KlienciRepository
        return mv;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView doDelete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("redirect:/klienci/all"); // wracamy do wyświetlenia wszystkich rekordów
        klienciRepository.delete(id); //usuwamy rekord z naszego repozytorium
        return mv;
    }

    @PostMapping(value = "/add")
    public ModelAndView doAdd(@ModelAttribute(name="formKlienci") FormKlienci klient, Model model) {
        ModelAndView mv = new ModelAndView("redirect:/klienci/all");
        model.addAttribute("formKlienci", klient); //dodajemy gotowy już obiekt FormKlienci do modelu
        Klienci nowyKlient = klient.formToKlient(); //konwersja naszą metodą z klady FormKlienci
        klienciRepository.save(nowyKlient); //zapisujemy do bazy
        return mv;
    }
}