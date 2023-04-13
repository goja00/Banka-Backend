package rppbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import rppbackend.model.Filijala;
import rppbackend.service.FilijalaService;

@CrossOrigin
@RestController
public class FilijalaController {
    @Autowired
    private FilijalaService filijalaService;

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

        if (filijalaService.existsById(id)) {
            filijalaService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Gets Filijala by Naziv.")
    @GetMapping("filijala/naziv/{naziv}")
    public ResponseEntity<List<Filijala>> getByNaziv(@PathVariable("naziv") String naziv){
        List<Filijala> f=filijalaService.findByNazivContainingIgnoreCase(naziv);
        return new ResponseEntity<>(f,HttpStatus.OK);

    }
    @ApiOperation(value = "Gets Filijala by Poseduje_sef.")
    @GetMapping("filijala/poseduje_sef")
    private ResponseEntity<List<Filijala>> getbyPoseduje_sef()
    {
        List<Filijala> f =filijalaService.findByPoseduje_sefTrue();
        return ResponseEntity.ok().body(f);
    }



}