package rppbackend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@NamedQuery(name="Banka.findAll", query="SELECT b FROM Banka b")
public class Banka  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @SequenceGenerator(name="Banka_ID_Generator",sequenceName = "Banka_Seq",allocationSize = 1)
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator= "Banka_ID_Generator")
    private int id;
    private String naziv;
    private String kontakt;
    private int pib;
    @OneToMany(mappedBy = "banka")
    @JsonIgnore
    private List<Filijala> filijala;

    public List<Filijala> getFilijala() {
		return filijala;
	}

	public void setFilijala(List<Filijala> filijala) {
		this.filijala = filijala;
	}

	public Banka() {
        super();
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public int getPIB() {
        return pib;
    }

    public void setPIB(int PIB) {
        this.pib = PIB;
    }
}
