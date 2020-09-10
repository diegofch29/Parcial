package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import java.math.BigInteger;

public class PrimeFinder extends Thread{
        
	private BigInteger a;
        private BigInteger b;
        private PrimesResultSet prs;
	
        
	public PrimeFinder(BigInteger _a, BigInteger _b, PrimesResultSet prs_){
                this.a= _a;
                this.b= _b;
                this.prs = prs_;
        }
        
	
	public void run(){
            MathUtilities mt=new MathUtilities();
                
                int itCount=0;
            
                BigInteger i=this.a;
                while (i.compareTo(b)<=0){
                    itCount++;
                    if (mt.isPrime(i)){
                        this.prs.addPrime(i);
                    }

                    i=i.add(BigInteger.ONE);
                }
                
        }
	
	
	
}
