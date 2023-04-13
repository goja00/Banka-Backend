package rppbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rppbackend.model.Korisnik_usluge;

public interface Korisnik_uslugeRepository extends JpaRepository<Korisnik_usluge,Integer> {
    List<Korisnik_usluge> findByimeContainingIgnoreCase(String ime);
}
