package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import java.util.ArrayList;

import java.util.List;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
public class PrimeServiceStub implements PrimeService{
    ArrayList<FoundPrime> Primes = new ArrayList<FoundPrime>();
    @Override
    public void addFoundPrime( FoundPrime foundPrime )    {
        for (FoundPrime prime_ : Primes){
            if(prime_.getPrime() == foundPrime.getPrime()){
                break;
            };
        }
        Primes.add(foundPrime);
    }

    @Override
    public List<FoundPrime> getFoundPrimes() {
        //TODO
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
