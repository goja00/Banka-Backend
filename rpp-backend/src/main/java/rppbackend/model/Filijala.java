package rppbackend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Filijala", schema = "public")
@NamedQuery(name="Filijala.findAll", query="SELECT f FROM Filijala f")
public class Filijala implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @SequenceGenerator(name="Filijala_ID_Generator",sequenceName = "Filijala_Seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Filijala_ID_Generator")
private int ID;
private String Adresa;
private int Broj_pultova;
private boolean Poseduje_sef;
@ManyToOne
@JoinColumn(name="banka")
private Banka banka;

@OneToMany(mappedBy = "filijala")
@JsonIgnore
private List<Usluga> usluga;


    public Filijala() {
        super();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public int getBroj_pultova() {
        return Broj_pultova;
    }

    public void setBroj_pultova(int broj_pultova) {
        Broj_pultova = broj_pultova;
    }

    public boolean isPoseduje_sef() {
        return Poseduje_sef;
    }

    public void setPoseduje_sef(boolean poseduje_sef) {
        Poseduje_sef = poseduje_sef;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }
}
