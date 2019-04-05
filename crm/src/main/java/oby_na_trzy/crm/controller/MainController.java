package oby_na_trzy.crm.controller;

import oby_na_trzy.crm.model.FormKlienci;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    String home(ModelMap modelMap){
        return "index";
    }

    @RequestMapping("/klienci/add")
    String getFormKlienci(Model model){
        model.addAttribute("formKlienci", new FormKlienci());
        return "formularz";
    }
}
