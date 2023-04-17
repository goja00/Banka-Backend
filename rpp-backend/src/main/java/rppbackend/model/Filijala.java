package rppbackend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Filijala", schema = "public")
@NamedQuery(name="Filijala.findAll", query="SELECT f FROM Filijala f")
public class Filijala implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @SequenceGenerator(name="Filijala_ID_Generator",sequenceName = "Filijala_Seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Filijala_ID_Generator")
private int id;
private String adresa;
private int broj_pultova;
private boolean posedujeSef;
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
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getBroj_pultova() {
        return broj_pultova;
    }

    public void setBroj_pultova(int broj_pultova) {
        this.broj_pultova = broj_pultova;
    }

    public boolean isPoseduje_sef() {
        return posedujeSef;
    }

    public void setposedujeSef(boolean poseduje_sef) {
        this.posedujeSef = poseduje_sef;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

	public List<Usluga> getUsluga() {
		return usluga;
	}

	public void setUsluga(List<Usluga> usluga) {
		this.usluga = usluga;
	}
}
