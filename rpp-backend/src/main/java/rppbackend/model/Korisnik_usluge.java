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
    private int id;
    private String ime;
    private String prezime;
    private String maticniBroj;
    @OneToMany(mappedBy = "korisnikUsluge",cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Usluga> usluga;

    public Korisnik_usluge() {
        super();
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getMaticni_broj() {
        return maticniBroj;
    }

    public void setMaticni_broj(String maticni_broj) {
        this.maticniBroj = maticni_broj;
    }

    public List<Usluga> getUsluga() {
        return usluga;
    }

    public void setUsluga(List<Usluga> usluga) {
        this.usluga = usluga;
    }
}