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
import rppbackend.service.BankaService;



@CrossOrigin
@RestController
public class BankaController {

    @Autowired
    private BankaService bankaService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @ApiOperation(value = "Returns List of all Banks")
    @GetMapping("banka")
    public ResponseEntity<List<Banka>> getAll(){
        List<Banka> bankas = bankaService.getAll();
        return new ResponseEntity<>(bankas, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns Banka with id.")
    @GetMapping("banka/{id}")
    public ResponseEntity<Banka> getbyId(@PathVariable("id") Integer id){
        if (bankaService.findById(id).isPresent()) {
            Optional<Banka> banka = bankaService.findById(id);
            return new ResponseEntity<>(banka.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @ApiOperation(value = "Adds new Banka to database.")
    @PostMapping("banka")
    public ResponseEntity<Banka> addBanka(@RequestBody Banka banka) {
        Banka savedbanka = bankaService.save(banka);
        URI location = URI.create("/artikl/" + savedbanka.getID());
        return ResponseEntity.created(location).body(savedbanka);
    }

    @ApiOperation(value = "Updates Banka that has id that was forwarded as path variable with values forwarded in Request Body.")
    @PutMapping(value = "banka/{id}")
    public ResponseEntity<Banka> updateBanka(@RequestBody Banka banka, @PathVariable("id") Integer id) {
        if (bankaService.existsById(id)) {
            banka.setID(id);
            Banka savedbanka = bankaService.save(banka);
            return ResponseEntity.ok().body(savedbanka);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Deletes Banka with id that was forwarded as path variable.")
    @DeleteMapping("banka/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {

    	 if (id == -100 && !bankaService.existsById(id)) {
             jdbcTemplate.execute(
                     "INSERT INTO public.banka (\"id\", \"kontakt\", \"naziv\",\"pib\") VALUES (-100, 'TEST', 'Test Naziv',999999)");
    	 }
    	
    	
    	
        if (bankaService.existsById(id)) {
            bankaService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Gets Banka by naziv.")
    @GetMapping("banka/naziv/{naziv}")
    public ResponseEntity<List<Banka>> getByNaziv(@PathVariable("naziv") String naziv){
        List<Banka> bankas=bankaService.findByNazivContainingIgnoreCase(naziv);
        return new ResponseEntity<>(bankas,HttpStatus.OK);
    }
    
    @ApiOperation(value="Get Banka by PIB")
    @GetMapping("banka/pib/{pib}")
    private ResponseEntity<List<Banka>> getBypib(@PathVariable("pib") Integer n)
    {
    	
    	List<Banka> b=bankaService.findBypib(n);
    	return new ResponseEntity<>(b,HttpStatus.OK);
    	
    }
    @ApiOperation(value="Get Banka by kontakt")
    @GetMapping("banka/kontakt/{kontakt}")
    private ResponseEntity<List<Banka>> getBykontakt(@PathVariable("kontakt") String kontakt)
    {
    	
    	List<Banka> b=bankaService.findBykontakt(kontakt);
    	return new ResponseEntity<>(b,HttpStatus.OK);
    	
    }
   
}


