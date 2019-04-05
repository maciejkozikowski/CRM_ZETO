package oby_na_trzy.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping("/")
    String home(ModelMap modelMap){
        return "index";
    }

    @RequestMapping("/klienci/add")
    String getFormKlienci(ModelMap modelMap){
        return "formularz";
    }

}
