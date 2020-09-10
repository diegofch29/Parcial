package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@Service
public class PrimeServiceStub implements PrimeService{
    ArrayList<FoundPrime> Primes = new ArrayList<FoundPrime>();
    @Override
    public void addFoundPrime( FoundPrime foundPrime )    {
        for (FoundPrime prime_ : Primes){
            if(prime_.getPrime().contains(foundPrime.getPrime())) try {
                throw new ExptionService("prime alredy in the system");
            } catch (ExptionService ex) {
                Logger.getLogger(PrimeServiceStub.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Primes.add(foundPrime);
    }

    @Override
    public List<FoundPrime> getFoundPrimes() {
        return Primes;
    }

    @Override
    public FoundPrime getPrime( String prime ) {
        FoundPrime found;
        for (FoundPrime prime_ : Primes){
            if(prime_.getPrime() == prime){
                return prime_;
            }
        }
        return null;
    }
}
