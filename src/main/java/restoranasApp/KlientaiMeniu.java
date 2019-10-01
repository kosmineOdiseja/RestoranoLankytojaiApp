package restoranasApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class KlientaiMeniu {
    private static final long serialVersionUID = -6790693372846798580L;	
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
	private Integer id;
    
	private Integer meniu_id;
	private Integer klientas_id;
    
    @JsonIgnoreProperties("klientaiKeliones")
    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
    private Klientai klientai;
    
    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
    private Meniu meniu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMeniu_id() {
		return meniu_id;
	}

	public void setMeniu_id(Integer meniu_id) {
		this.meniu_id = meniu_id;
	}

	public Integer getKlientas_id() {
		return klientas_id;
	}

	public void setKlientas_id(Integer klientas_id) {
		this.klientas_id = klientas_id;
	}
  
   }
