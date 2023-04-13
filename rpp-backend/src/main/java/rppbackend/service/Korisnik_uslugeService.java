package rppbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rppbackend.model.Korisnik_usluge;
import rppbackend.repository.Korisnik_uslugeRepository;

@Service
public class Korisnik_uslugeService {

    @Autowired
    private Korisnik_uslugeRepository korisnikUslugeRepository;

    public List<Korisnik_usluge> getAll(){
        return korisnikUslugeRepository.findAll();
    }

    public Optional<Korisnik_usluge> findById(Integer id) {
        return korisnikUslugeRepository.findById(id);
    }

    public List<Korisnik_usluge> findByNazivContainingIgnoreCase(String naziv) {
        return korisnikUslugeRepository.findByImeContainingIgnoreCase(naziv);
    }
    public Korisnik_usluge save(Korisnik_usluge banka) {
        return korisnikUslugeRepository.save(banka);
    }

    public boolean existsById(Integer id) {
        return korisnikUslugeRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        korisnikUslugeRepository.deleteById(id);
    }

}