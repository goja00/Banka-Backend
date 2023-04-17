package rppbackend.model;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Usluga", schema = "public")
@NamedQuery(name="Usluga.findAll", query="SELECT u FROM Usluga u")
public class Usluga {
    @Id
    @SequenceGenerator(name="Usluga_ID_Generator",sequenceName = "Usluga_Seq",allocationSize = 1)
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator= "Usluga_ID_Generator")
    private int id;
    private String naziv;
    private String opis_usluge;
    private Date datumUgovora;
    private float provizija;
    @ManyToOne
    @JoinColumn(name="filijala")
    private Filijala filijala;
    @ManyToOne
    @JoinColumn(name="korisnikUsluge")
    private Korisnik_usluge korisnikUsluge;

    public Usluga() {
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

    public String getOpis_usluge() {
        return opis_usluge;
    }

    public void setOpis_usluge(String opis_usluge) {
        this.opis_usluge = opis_usluge;
    }

    public Date getDatum_ugovora() {
        return datumUgovora;
    }

    public void setDatum_ugovora(Date datum_ugovora) {
        this.datumUgovora = datum_ugovora;
    }

    public float getProvizija() {
        return provizija;
    }

    public void setProvizija(float provizija) {
        this.provizija = provizija;
    }

    public Filijala getFilijala() {
        return filijala;
    }

    public void setFilijala(Filijala filijala) {
        this.filijala = filijala;
    }

    public Korisnik_usluge getKorisnik_usluge() {
        return korisnikUsluge;
    }

    public void setKorisnik_usluge(Korisnik_usluge korisnik_usluge) {
        this.korisnikUsluge = korisnik_usluge;
    }
}