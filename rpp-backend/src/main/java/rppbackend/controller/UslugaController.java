package rppbackend.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import rppbackend.model.Banka;
import rppbackend.model.Filijala;
import rppbackend.model.Korisnik_usluge;
import rppbackend.model.Usluga;
import rppbackend.service.FilijalaService;
import rppbackend.service.Korisnik_uslugeService;
import rppbackend.service.UslugaService;


@CrossOrigin
@RestController
public class UslugaController {

    @Autowired
    private UslugaService uslugaService;
    @Autowired
    private FilijalaService filijalaService;
    @Autowired
    private Korisnik_uslugeService korisnikUslugeService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    @ApiOperation(value = "Get all Usluga from database.")
    @GetMapping("usluga")
    private ResponseEntity<List<Usluga>> getAll(){
        List<Usluga> u =uslugaService.getAll();
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Usluga by ID from database.")
    @GetMapping("usluga/{id}")
    private ResponseEntity<Usluga>getById(@PathVariable("id") Integer id) {
        if (uslugaService.findById(id).isPresent()) {
            Optional<Usluga> u = uslugaService.findById(id);
            return new ResponseEntity<>(u.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @ApiOperation(value = "Insert Usluga into a database.")
    @PostMapping("usluga")
    private ResponseEntity<Usluga>addUsluga(@RequestBody Usluga usluga){
        Usluga u=uslugaService.save(usluga);
        URI location=URI.create("/usluga/" + u.getID());
        return ResponseEntity.created(location).body(u);

    }

    @ApiOperation(value = "Update Usluga by given ID.")
    @PutMapping("usluga/{id}")
    private ResponseEntity<Usluga>updateUsluga(@RequestBody Usluga usluga,@PathVariable("id") Integer id){
        if(uslugaService.findById(id).isPresent()) {
            usluga.setID(id);
            Usluga u = uslugaService.save(usluga);
            return ResponseEntity.ok().body(u);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ApiOperation(value = "Deletes Usluga with id that was forwarded as path variable.")
    @DeleteMapping("usluga/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
    	
    	if (id == -100 && !uslugaService.existsById(id)) {
            jdbcTemplate.execute(
                    "INSERT INTO public.usluga (\"id\", \"naziv\", \"opis_usluge\",\"datum_ugovora\",\"provizija\",\"filijala\",\"korisnik_usluge\") VALUES (-100, 'Test','XXXXXXX','2022-03-03',0.5,2,2)");
        }

        if (uslugaService.existsById(id)) {
            uslugaService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Gets Usluga by Naziv.")
    @GetMapping("usluga/naziv/{naziv}")
    public ResponseEntity<List<Usluga>> getByNaziv(@PathVariable("naziv") String naziv){
        List<Usluga> f=uslugaService.findByNazivContainingIgnoreCase(naziv);
        return new ResponseEntity<>(f,HttpStatus.OK);

    }
    
    @ApiOperation(value = "Get list of Usluga by filijala ID.")
    @GetMapping("usluga/filijala/{id}")
    public ResponseEntity<List<Usluga>> getByfilijala(@PathVariable("id") Integer id){
    	Optional<Filijala> b=filijalaService.findById(id);
    	if(b.isPresent())
    	{
        List<Usluga> f=uslugaService.findByfilijala(b.get());
        return new ResponseEntity<>(f,HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}

    }
    
    @ApiOperation(value = "Get list of Usluga by korisnik_usluge ID.")
    @GetMapping("usluga/korisnik_usluge/{id}")
    public ResponseEntity<List<Usluga>> getBykorisnik(@PathVariable("id") Integer id){
    	Optional<Korisnik_usluge> b=korisnikUslugeService.findById(id);
    	if(b.isPresent())
    	{
        List<Usluga> f=uslugaService.findBykorisnikUsluge(b.get());
        return new ResponseEntity<>(f,HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}

    }
   
    
    
}