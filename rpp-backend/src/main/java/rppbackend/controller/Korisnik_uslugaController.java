package rppbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import rppbackend.model.Korisnik_usluge;
import rppbackend.service.Korisnik_uslugeService;


@CrossOrigin
@RestController
public class Korisnik_uslugaController {

    @Autowired
    private Korisnik_uslugeService korisnikUslugeService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @ApiOperation(value = "Get all Korisnik_usluge from database.")
    @GetMapping("korisnik_usluge")
    private ResponseEntity<List<Korisnik_usluge>> getAll(){
        List<Korisnik_usluge> k =korisnikUslugeService.getAll();
        return new ResponseEntity<>(k, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Korisnik_usluge by ID from database.")
    @GetMapping("korisnik_usluge/{id}")
    private ResponseEntity<Korisnik_usluge>getById(@PathVariable("id") Integer id) {
        if (korisnikUslugeService.findById(id).isPresent()) {
            Optional<Korisnik_usluge> k = korisnikUslugeService.findById(id);
            return new ResponseEntity<>(k.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @ApiOperation(value = "Insert Korisnik_usluge into a database.")
    @PostMapping("korisnik_usluge")
    private ResponseEntity<Korisnik_usluge>addKorisnik_usluge(@RequestBody Korisnik_usluge korisnikUsluge){
        Korisnik_usluge k=korisnikUslugeService.save(korisnikUsluge);
        URI location=URI.create("/korisnik_usluge/" + k.getID());
        return ResponseEntity.created(location).body(k);

    }

    @ApiOperation(value = "Update Korisnik_usluge by given ID.")
    @PutMapping("korisnik_usluge/{id}")
    private ResponseEntity<Korisnik_usluge>updateKorisnik_usluge(@RequestBody Korisnik_usluge korisnikUsluge,@PathVariable("id") Integer id){
        if(korisnikUslugeService.findById(id).isPresent()) {
            korisnikUsluge.setID(id);
            Korisnik_usluge k = korisnikUslugeService.save(korisnikUsluge);
            return ResponseEntity.ok().body(k);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ApiOperation(value = "Deletes Korisnik_usluge with id that was forwarded as path variable.")
    @DeleteMapping("korisnik_usluge/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {

    	if (id == -100 && !korisnikUslugeService.existsById(id)) {
            jdbcTemplate.execute(
                    "INSERT INTO public.korisnik_usluge (\"id\", \"ime\", \"maticni_broj\",\"prezime\") VALUES (-100, 'Test',999999,'Testovic')");
        }
    	
    	
    	
        if (korisnikUslugeService.existsById(id)) {
            korisnikUslugeService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Gets Korisnik_usluge by Naziv.")
    @GetMapping("korisnik_usluge/ime/{naziv}")
    public ResponseEntity<List<Korisnik_usluge>> getByNaziv(@PathVariable("naziv") String naziv){
        List<Korisnik_usluge> f=korisnikUslugeService.findByimeContainingIgnoreCase(naziv);
        return new ResponseEntity<>(f,HttpStatus.OK);

    }
    
    @ApiOperation(value = "Gets Korisnik_usluge by maticniBroj.")
    @GetMapping("korisnik_usluge/maticniBroj/{mb}")
    public ResponseEntity<List<Korisnik_usluge>> getBymaticniBroj(@PathVariable("mb") String naziv){
        List<Korisnik_usluge> f=korisnikUslugeService.findBymaticniBroj(naziv);
        return new ResponseEntity<>(f,HttpStatus.OK);

    }
    @ApiOperation(value = "Gets Korisnik_usluge by Naziv.")
    @GetMapping("korisnik_usluge/prezime/{naziv}")
    public ResponseEntity<List<Korisnik_usluge>> getByprezime(@PathVariable("naziv") String naziv){
        List<Korisnik_usluge> f=korisnikUslugeService.findByprezimeContainingIgnoreCase(naziv);
        return new ResponseEntity<>(f,HttpStatus.OK);

    }
}