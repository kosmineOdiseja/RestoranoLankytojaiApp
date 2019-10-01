package restoranasApp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping(path="/ajax")
public class AjaxConroller {
	
	@Autowired
	KlientoInformacijaRepository klientoInformacijaRepository;
	
	@GetMapping(path="/saugoti-klientai") 
	public @ResponseBody String saugotiklientai (@RequestParam Integer id 
			, @RequestParam String vardas
			, @RequestParam String pavarde
			, @RequestParam Integer vartojaAlkGer
			, @RequestParam Integer alergRie	
			, @RequestParam	Integer alergPienPro	
			) {
	
		String res = "Not done";
		KlientoInformacija n = new KlientoInformacija();
		
		if (id > 0) {
			Optional <KlientoInformacija> found = klientoInformacijaRepository.findById( id );
			
			if ( found.isPresent() ) {
				
				   n = found.get();
				   n.setId(id);
				}
			}
		n.setVardas(vardas);
		n.setPavarde(pavarde);
		n.setVartojaAlkGer(vartojaAlkGer);
		n.setAlergRie(alergRie);
		n.setAlergPienPro(alergPienPro);
		klientoInformacijaRepository.save(n);
	    res = "Saved";
	    
		return res;	
		
		}
	@GetMapping(path="/salinti-klienta") 
	public @ResponseBody String salintiKlienta (@RequestParam Integer id 
			) {
				
		Optional <KlientoInformacija> found = klientoInformacijaRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			KlientoInformacija n = found.get();
			klientoInformacijaRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}
	
	@GetMapping(path="/lst-klientai")
	public @ResponseBody Iterable<KlientoInformacija> getAllKlientai() {
		// This returns a JSON or XML with the users
		return klientoInformacijaRepository.findAll();
	}	
	
}
