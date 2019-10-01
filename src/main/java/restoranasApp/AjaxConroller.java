package restoranasApp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author user Alius Bosas
 *data 2019 10 01
 */
@Controller 
@RequestMapping(path="/ajax")
public class AjaxConroller {
	
	
	/**
	 * autowired controleris klientoInformacijaiRepository
	 * 
	 */
	@Autowired
	KlientoInformacijaRepository klientoInformacijaRepository;
	
	/**
	 *  autowired controleris meniuRepositorijai
	 */
	@Autowired
	MeniuRepository meniuRepository;
	
	/**
	 * @param id perduodami parametrai
	 * @param vardas perduodami parametrai
	 * @param pavarde perduodami parametrai
	 * @param vartojaAlkGer perduodami parametrai
	 * @param alergRie perduodami parametrai
	 * @param alergPienPro perduodami parametrai
	 * @return grazinama reiksme!
	 */
	
	@GetMapping(path="/saugoti-klienta") 
	public @ResponseBody String saugotiklienta (@RequestParam Integer id 
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
	/**
	 * @param id perduodamas id 
	 * @return grazinimas
	 */
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
	
	/**
	 * @return
	 * grazinamas klientoInformacijaRepository
	 */
	@GetMapping(path="/lst-klientai")
	public @ResponseBody Iterable<KlientoInformacija> getAllKlientai() {
		// This returns a JSON or XML with the users
		return klientoInformacijaRepository.findAll();
	}	
	
	/**
	 * @param id reikalaujam parametro
	 * @param patiekalas reikalaujam parametro
	 * @param sudYraiRes reikalaujam parametro
	 * @param sudYraPien reikalaujam parametro
	 * @return  grazinam reiksme res
	 */
	@GetMapping(path="/saugoti-meniu") 
	public @ResponseBody String saugotimeniu (@RequestParam Integer id 
			, @RequestParam String patiekalas
			, @RequestParam Integer sudYraiRes
			, @RequestParam Integer sudYraPien	
			) {
	
		String res = "Not done";
		Meniu n = new Meniu();
		
		if (id > 0) {
			Optional <Meniu> found = meniuRepository.findById( id );
			
			if ( found.isPresent() ) {
				
				   n = found.get();
				   n.setId(id);
				}
			}
		n.setPatiekalas(patiekalas);
		n.setSudYrapien(sudYraiRes);
		n.setSudYrapien(sudYraPien);
		meniuRepository.save(n);
	    res = "Saved";
	    
		return res;	
		
		}
	
	/**
	 * @param id perduodam parametra 
	 * @return grazinam res reiksme
	 */
	@GetMapping(path="/salinti-meniu") 
	public @ResponseBody String salintiMeniu (@RequestParam Integer id 
			) {
				
		Optional <Meniu> found = meniuRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
		Meniu n = found.get();
			meniuRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}
	
	/**
	 * @return grazinam meniuRepository
	 */
	@GetMapping(path="/lst-meniu")
	public @ResponseBody Iterable<Meniu> getAllMeniu() {
		// This returns a JSON or XML with the users
		return meniuRepository.findAll();
	
	}
}
