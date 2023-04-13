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
    private int ID;
    private String Naziv;
    private String Kontakt;
    private int PIB;
    @OneToMany(mappedBy = "banka")
    @JsonIgnore
    private List<Filijala> filijala;

    public Banka() {
        super();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }
    public String getKontakt() {
        return Kontakt;
    }

    public void setKontakt(String kontakt) {
        Kontakt = kontakt;
    }

    public int getPIB() {
        return PIB;
    }

    public void setPIB(int PIB) {
        this.PIB = PIB;
    }
}
