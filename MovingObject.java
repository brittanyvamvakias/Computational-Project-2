
public class MovingObject {
 	    
	   double cof,dt; 
	   double x,y,vx,vy,E, y0, x0, w1x, w1y, vya, vxa, vy0, vx0, x1a, y1a, w2x, w2y, u1x, u1y, u2x, u2y;
	   private double ax,ay,r,r2;      
	   private double s,fs,bs;

       public MovingObject(){System.out.println("A new moving object is created.");					      
       }		     	      
//------------------object properties       
	   public void energy(){
			E=0.5*(vx*vx+vy*vy)-1./Math.sqrt(x*x+y*y);
	   }
	   public void accel(){
			r2 =x*x+y*y;
			r  =Math.sqrt(r2);
			ax=-x/r/r2;
			ay=-y/r/r2;
	   }
//------------------object motion       
	   public void positionstep(double cof){
	    			      x = x+vx*dt*cof; 
	    			      y = y+vy*dt*cof; 
	   }
	   public void velocitystep(double cof){
	                      accel();
	    			      vx = vx+ax*dt*cof; 
	    			      vy = vy+ay*dt*cof; 
	   }
	   public void sym1bstep(double cof){
						positionstep(cof);
						velocitystep(cof);
	   }
	   public void sym1astep(double cof){
						velocitystep(cof);
						positionstep(cof);
	   }
	   public void sym2astep(double cof){
						sym1astep(0.5*cof);
						sym1bstep(0.5*cof);
	   }
	   public void RK2step(){
						u1x = x;
						u1y = y;
						w1x = vx;
						w1y = vy;
							sym1astep(1.0);
						u2x = x;
						u2y = y;
						w2x = vx;
						w2y = vy;
						
						x = u1x;
						y = u1y;
						vx = w1x;
						vy = w1y;
							sym1bstep(1.0);
						x = 0.5*(x+u2x);
						y = 0.5*(y+u2y);
						vx = 0.5*(vx+w2x);
						vy = 0.5*(vy+w2y);
						
	   }
}
