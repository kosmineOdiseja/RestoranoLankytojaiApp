package restoranasApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author user Alius Bosas
 * data 2019 10 01
 */

@Entity
public class Meniu {
	

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String patiekalas;
    private Integer udYraRies;
    private Integer sudYrapien;
    
    

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPatiekalas() {
		return patiekalas;
	}
	public void setPatiekalas(String patiekalas) {
		this.patiekalas = patiekalas;
	}
	public Integer getUdYraRies() {
		return udYraRies;
	}
	public void setUdYraRies(Integer udYraRies) {
		this.udYraRies = udYraRies;
	}
	public Integer getSudYrapien() {
		return sudYrapien;
	}
	public void setSudYrapien(Integer sudYrapien) {
		this.sudYrapien = sudYrapien;
	}
}
