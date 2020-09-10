package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@RestController
@RequestMapping(value = "/primes")
public class PrimesController
{

    PrimeService primeService;


    @RequestMapping(method = GET )
    public ResponseEntity<?> getPrimes(){
        try{ 
            return new ResponseEntity<>(primeService.getFoundPrimes(), HttpStatus.ACCEPTED);
        }
        catch (Exception ex) {
            return new ResponseEntity<>("HTTP 404, Resource not found :(", HttpStatus.ALREADY_REPORTED);
        }
    }
    
    
    @RequestMapping( value = "/{primenumber}", method = GET )
    public ResponseEntity<?> getPrimeNumber(@PathVariable String primenumber)    {
        try {
            return new ResponseEntity<>(primeService.getPrime(primenumber), HttpStatus.ACCEPTED);
        }
        catch (Exception ex) {
            return new ResponseEntity<>("HTTP 404, Resource not found :(", HttpStatus.NOT_FOUND);
            
        }
        
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPrime( @RequestBody String name ) {
        try{
            String[] names = name.replace("\"user\":","").replace("\"prime\":","").replace("}","").replace("{","").split(",");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception ex) {
            return new ResponseEntity<>("HTTP 404, Resource not found :(", HttpStatus.NOT_FOUND);    
        }
        
    }
    
}
