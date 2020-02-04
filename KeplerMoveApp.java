
import java.io.*;

public class KeplerMoveApp {

	public static void main(String[] args) {
 
	    double x0 = 10.;   
	    double vx0 = 0.;  
	    double y0 = 0.;   
	    double vy0 = 0.1;  
		double t=0.;
		double dt=0.0759;
		double E0, P;

 	    MovingObject planet =new MovingObject();
	    
	    planet.dt = dt; 
	    planet.x  = x0;
	    planet.vx = vx0;
	    planet.y  = y0;
	    planet.vy = vy0;
		
		MovingObject asteroid =new MovingObject();
	    
	    asteroid.dt = dt; 
	    asteroid.x  = x0;
	    asteroid.vx = vx0;
		asteroid.y  = y0;
	    asteroid.vy = vy0;

	      
	      try{
	    	  FileWriter wtraject = new FileWriter("energy2.txt");
	    	  BufferedWriter trajectout = new BufferedWriter(wtraject);
 
	    	   for(int n = 0;n<5000;n++) {  
                     planet.sym2astep(1.0);	
					 asteroid.RK2step();
					 planet.energy();
					 asteroid.energy();
					 E0 = 0.5*(vx0*vx0+vy0*vy0)-1./Math.sqrt(x0*x0+y0*y0);
					 P = 75.853;
					 t=t+dt;
 
		      trajectout.write((planet.E-E0)/Math.abs(E0)+ " " + t/P + "  " + (asteroid.E-E0)/Math.abs(E0));
		      trajectout.newLine();
	    		                        } //end of loop    
	    	  trajectout.close(); 
				//close output 
	    	  }catch (Exception e){//Catch exception if any
	    	   System.err.println("Error: " + e.getMessage());
	    	                      }
		System.out.println("  ");					      
		System.out.println("All done!");					      
	}

}
