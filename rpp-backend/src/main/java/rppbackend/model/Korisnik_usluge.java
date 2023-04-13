package rppbackend.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Korisnik_usluge", schema = "public")
@NamedQuery(name="Korisnik_usluge.findAll", query="SELECT k FROM Korisnik_usluge k")
public class Korisnik_usluge {
    @Id
    @SequenceGenerator(name="Korisnik_usluge_ID_Generator",sequenceName = "Korisnik_usluge_Seq",allocationSize = 1)
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator= "Korisnik_usluge_ID_Generator")
    private int ID;
    private String Ime;
    private String Prezime;
    private String Maticni_broj;
    @OneToMany(mappedBy = "korisnik_usluge",cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Usluga> usluga;

    public Korisnik_usluge() {
        super();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    public String getMaticni_broj() {
        return Maticni_broj;
    }

    public void setMaticni_broj(String maticni_broj) {
        Maticni_broj = maticni_broj;
    }

    public List<Usluga> getUsluga() {
        return usluga;
    }

    public void setUsluga(List<Usluga> usluga) {
        this.usluga = usluga;
    }
}