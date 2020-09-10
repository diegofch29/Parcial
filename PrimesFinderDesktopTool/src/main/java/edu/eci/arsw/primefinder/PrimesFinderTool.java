package edu.eci.arsw.primefinder;


import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class PrimesFinderTool extends Thread{

	public static void main(String[] args) {
		            
            int maxPrim=1000;
            
            PrimesResultSet prs=new PrimesResultSet("john");
            
            
            //PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("10000"), prs);
            ArrayList<PrimeFinder> Finders =  new ArrayList<PrimeFinder>();
            
            BigInteger start = new BigInteger("1");
            BigInteger finish = new BigInteger("1000");
            BigInteger lip = finish.subtract(start).divide(new BigInteger("4")).add(new BigInteger("1"));
            BigInteger range = lip;
            
                    
            for (int i = 0;i<4;i++){
                System.out.println(i+"\t"+start+"\t"+range+"\t");
                Finders.add(new PrimeFinder(start,range,prs));
                start=range.add(new BigInteger("1"));
                range=range.add(lip);
            }
            
            Finders.forEach((i) -> {
                i.start();
                try {
                    i.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            boolean task_not_finished=true;
            
            
            /*while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");
                    }
                    else{
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
            
            System.out.println("Prime numbers found:");
            
            System.out.println(prs.getPrimes());

                        
            
            
            
            
	}
	
}


