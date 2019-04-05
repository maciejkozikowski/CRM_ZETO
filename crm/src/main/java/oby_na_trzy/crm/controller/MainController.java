package oby_na_trzy.crm.controller;

import oby_na_trzy.crm.model.FormKlienci;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //dodajemy do klasy kontrolera (czyli takiej klasy, która informuje które pliki .html mają być użyte
public class MainController {
    @RequestMapping("/") // tutaj wpisujemy adres, dla jakiego ma się wyświetlić dany html
    String home(ModelMap modelMap){ // ModelMap (lub Model) pozwala na modyfikacje strony (czyli tutaj "/")
        // ponieważ jest to strona główna, nic nie musimy robić
        return "index"; // po prostu zwracamy index.html
    }

    @RequestMapping("/klienci/add")
    String getFormKlienci(Model model){
        model.addAttribute("formKlienci", new FormKlienci());
        //dodajemy obiekt formularza dla klienta do modelu
        //formKlienci - pod taką nazwą musi znaleźć się tag form
        //new FormKlienci() - tworzymy nowy pusty obiekt
        return "formularz"; //zwracamy nazwę pliku, w którym znajduje sie formularz
    }
}
