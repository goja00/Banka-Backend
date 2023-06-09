package rppbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import rppbackend.model.Filijala;
import rppbackend.model.Korisnik_usluge;
import rppbackend.model.Usluga;

public interface UslugaRepository extends JpaRepository<Usluga,Integer> {

    List<Usluga> findBynazivContainingIgnoreCase(String naziv);
    List<Usluga> findByfilijala(Filijala f);
    List<Usluga> findBykorisnikUsluge(Korisnik_usluge ku);
}
