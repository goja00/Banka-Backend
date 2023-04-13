package rppbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rppbackend.model.Filijala;
import rppbackend.repository.FilijalaRepository;

@Service
public class FilijalaService {

    @Autowired
    private FilijalaRepository filijalaRepository;

    public List<Filijala> getAll(){
        return filijalaRepository.findAll();
    }

    public Optional<Filijala> findById(Integer id) {
        return filijalaRepository.findById(id);
    }

    public List<Filijala> findByNazivContainingIgnoreCase(String naziv) {
        return filijalaRepository.findByAdresaContainingIgnoreCase(naziv);
    }
    public List<Filijala>findByPoseduje_sefTrue(){
        return filijalaRepository.findByPoseduje_sefTrue();
    }
    public Filijala save(Filijala filijala) {
        return filijalaRepository.save(filijala);
    }

    public boolean existsById(Integer id) {
        return filijalaRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        filijalaRepository.deleteById(id);
    }

}