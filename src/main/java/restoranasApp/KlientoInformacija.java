package restoranasApp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class KlientoInformacija {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String vardas;
    private String pavarde;	
    private Integer vartojaAlkGer;	
    private Integer alergRie;	
    private Integer alergPienPro;
    
  @JsonIgnoreProperties("klientai")    
  @OneToMany(mappedBy = "klientai",cascade = CascadeType.ALL)
   private List<KlientaiMeniu> klientaiMeniu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVardas() {
		return vardas;
	}

	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	public String getPavarde() {
		return pavarde;
	}

	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}

	public Integer getVartojaAlkGer() {
		return vartojaAlkGer;
	}

	public void setVartojaAlkGer(Integer vartojaAlkGer) {
		this.vartojaAlkGer = vartojaAlkGer;
	}

	public Integer getAlergRie() {
		return alergRie;
	}

	public void setAlergRie(Integer alergRie) {
		this.alergRie = alergRie;
	}

	public Integer getAlergPienPro() {
		return alergPienPro;
	}

	public void setAlergPienPro(Integer alergPienPro) {
		this.alergPienPro = alergPienPro;
	}   
}
