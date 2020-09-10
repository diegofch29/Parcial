package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    PrimeService primeService;


    @RequestMapping(method = GET )
    public ResponseEntity<?> getPrimes(){
        try{ 
            System.out.println("getprimes");
            return new ResponseEntity<>(primeService.getFoundPrimes(), HttpStatus.ACCEPTED);
        }
        catch (Exception ex) {
            return new ResponseEntity<>("HTTP 404, Resource not found :(", HttpStatus.NOT_FOUND);
        }
    }
    
    
    @RequestMapping( value = "/{primenumber}", method = GET )
    public ResponseEntity<?> getPrimeNumber(@PathVariable String primenumber)    {
        try {
            System.out.println("getprimeNumber");
            return new ResponseEntity<>(primeService.getPrime(primenumber), HttpStatus.ACCEPTED);
        }
        catch (Exception ex) {
            return new ResponseEntity<>("HTTP 404, Resource not found :(", HttpStatus.NOT_FOUND);
            
        }
        
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPrime( @RequestBody String name ) {
        try{
            System.out.println("addprimeNumber");
            String[] names = name.replace("\"user\":","").replace("\"prime\":","").replace("}","").replace("{","").split(",");
            FoundPrime prime = new FoundPrime();
            prime.setUser(names[0]);
            prime.setPrime(names[1]);
            primeService.addFoundPrime(prime);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception ex) {
            return new ResponseEntity<>("Ops prime alredy in the system :(", HttpStatus.ALREADY_REPORTED);    
        }
        
    }
    
}
