package restoranasApp;

import java.awt.Menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class PageController {
	
    @GetMapping("/")
    public String pradzia(Model model) {
        model.addAttribute("lst_menu");    	
        return "index";
    }	
	
    @GetMapping("/klientai")
    public String klientai(Model model) {
        model.addAttribute("lst_menu");    	
        return "klientai";
    }	
    //, Menu.values()
    @GetMapping("/klientas")
    public String klientas(@RequestParam Integer id, Model model) {
        model.addAttribute("lst_menu");
        return "klientas";
    } 
    
    @GetMapping("/meniu")
    public String meniu(Model model) {
        model.addAttribute("lst_menu");    	
        return "meniu";
    }	
}
