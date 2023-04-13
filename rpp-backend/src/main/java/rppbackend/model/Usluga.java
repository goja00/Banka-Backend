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
    private int ID;
    private String Naziv;
    private String Opis_usluge;
    private Date datum_ugovora;
    private float provizija;
    @ManyToOne
    @JoinColumn(name="filijala")
    private Filijala filijala;
    @ManyToOne
    @JoinColumn(name="korisnik_usluge")
    private Korisnik_usluge korisnik_usluge;

    public Usluga() {
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

    public String getOpis_usluge() {
        return Opis_usluge;
    }

    public void setOpis_usluge(String opis_usluge) {
        Opis_usluge = opis_usluge;
    }

    public Date getDatum_ugovora() {
        return datum_ugovora;
    }

    public void setDatum_ugovora(Date datum_ugovora) {
        this.datum_ugovora = datum_ugovora;
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
        return korisnik_usluge;
    }

    public void setKorisnik_usluge(Korisnik_usluge korisnik_usluge) {
        this.korisnik_usluge = korisnik_usluge;
    }
}