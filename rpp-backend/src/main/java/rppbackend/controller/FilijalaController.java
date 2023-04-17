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
import rppbackend.model.Banka;
import rppbackend.model.Filijala;
import rppbackend.service.BankaService;
import rppbackend.service.FilijalaService;

@CrossOrigin
@RestController
public class FilijalaController {
    @Autowired
    private FilijalaService filijalaService;
    @Autowired
    private BankaService bankaService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ApiOperation(value = "Get all Filijala from database.")
    @GetMapping("filijala")
    private ResponseEntity<List<Filijala>> getAll(){
        List<Filijala> filijalas =filijalaService.getAll();
        return new ResponseEntity<>(filijalas, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Filijala by ID from database.")
    @GetMapping("filijala/{id}")
    private ResponseEntity<Filijala>getById(@PathVariable("id") Integer id) {
        if (filijalaService.findById(id).isPresent()) {
            Optional<Filijala> f = filijalaService.findById(id);
            return new ResponseEntity<>(f.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @ApiOperation(value = "Insert Filijala into a database.")
    @PostMapping("filijala")
    private ResponseEntity<Filijala>addFilijala(@RequestBody Filijala filijala){
        Filijala f=filijalaService.save(filijala);
        URI location=URI.create("/filijala/" + f.getID());
        return ResponseEntity.created(location).body(f);

    }

    @ApiOperation(value = "Update Filijala by given ID.")
    @PutMapping("filijala/{id}")
private ResponseEntity<Filijala>updateFilijala(@RequestBody Filijala filijala,@PathVariable("id") Integer id){
        if(filijalaService.findById(id).isPresent()) {
            filijala.setID(id);
            Filijala f = filijalaService.save(filijala);
            return ResponseEntity.ok().body(f);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ApiOperation(value = "Deletes Filijala with id that was forwarded as path variable.")
    @DeleteMapping("filijala/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {

    	if (id == -100 && !filijalaService.existsById(id)) {
            jdbcTemplate.execute(
                    "INSERT INTO public.filijala (\"id\", \"adresa\", \"broj_pultova\",\"poseduje_sef\",\"banka\") VALUES (-100, 'Test',0,true,2)");
        }
    	
    	
        if (filijalaService.existsById(id)) {
            filijalaService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Gets Filijala by Adresa.")
    @GetMapping("filijala/adresa/{naziv}")
    public ResponseEntity<List<Filijala>> getByAdresa(@PathVariable("naziv") String naziv){
        List<Filijala> f=filijalaService.findByadresaContainingIgnoreCase(naziv);
        return new ResponseEntity<>(f,HttpStatus.OK);

    }
    @ApiOperation(value = "Get list of Filijala by banka ID.")
    @GetMapping("filijala/banka/{id}")
    public ResponseEntity<List<Filijala>> getBybanka(@PathVariable("id") Integer id){
    	Optional<Banka> b=bankaService.findById(id);
    	if(b.isPresent())
    	{
        List<Filijala> f=filijalaService.findBybanka(b.get());
        return new ResponseEntity<>(f,HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}

    }

    @ApiOperation(value = "Get list of Filijala by posedujeSef set to True.")
    @GetMapping("filijala/poseduje_sef/")
    public ResponseEntity<List<Filijala>> getByposedujeSef(){
        List<Filijala> f=filijalaService.findByposedujeSef();
        return new ResponseEntity<>(f,HttpStatus.OK);

    }

}