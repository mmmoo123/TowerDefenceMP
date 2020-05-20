package math;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Calculation {

    private Calculation(){};

    public static double distance(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2 ){
    	double distance;
        double centerX1 = x1 + (width1/2.0);
        double centerY1 = y1 + (height1/2.0);
        double centerX2 = x2 + (width2/2.0);
        double centerY2 = y2 + (height2/2.0);
        
        
        distance = sqrt(pow(centerX2 - centerX1,2) + pow(centerY2 - centerY1,2));
        

        return distance;
    }
    
    public static boolean isCursorOver(int cursorX, int cursorY, int objectX, int objectY, int width, int height ){

        if(cursorX >= objectX && cursorX <= objectX + width && cursorY >= objectY && cursorY <= objectY + height){
        	return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean collision(double distance){
    		
	    	if(distance < 50){
	    		return true;
	        }
	        else
	            return false;
	    	
	 }
    
    
    public static boolean isLower(int cursorX, int cursorY, int objectX, int objectY) {
    	if(cursorX < objectX && cursorY > objectY)
    		return true;
    	else
    		return false;
    }
    
    public static boolean collisionWithRoad(int cursorX, int cursorY, int width, int height, int offset ){
    	 if((cursorX+(width/2) > 50+offset && cursorX-(width/2) < 100+offset) && cursorY-(height/2) < 200)
    		 return true;
    	 else if((cursorX+(width/2) > 50+offset && cursorX-(width/2) < 200+offset) && (cursorY-(height/2) < 200 && cursorY+(height/2) > 100))
    		 return true;
    	 else if((cursorX+(width/2) > 150+offset && cursorX-(width/2) < 200+offset) && (cursorY-(height/2) < 200 && cursorY+(height/2) > 50))
    		 return true;
    	 else if((cursorX+(width/2) > 150+offset && cursorX-(width/2) < 450+offset) && (cursorY-(height/2) < 100 && cursorY+(height/2) > 50))
    		 return true;
    	 else if((cursorX+(width/2) > 400+offset && cursorX-(width/2) < 450+offset) && (cursorY-(height/2) < 350 && cursorY+(height/2) > 50))
    		 return true;
    	 else if((cursorX+(width/2) > 250+offset && cursorX-(width/2) < 450+offset) && (cursorY-(height/2) < 350 && cursorY+(height/2) > 300))
    		 return true;
    	 else if((cursorX+(width/2) > 250+offset && cursorX-(width/2) < 300+offset) && (cursorY-(height/2) < 500 && cursorY+(height/2) > 350))
    		 return true;
    	 else if((cursorX+(width/2) > 50+offset && cursorX-(width/2) < 300+offset) && (cursorY-(height/2) < 500 && cursorY+(height/2) > 450))
    		 return true;
    	 else if((cursorX+(width/2) > 50+offset && cursorX-(width/2) < 100+offset) && (cursorY-(height/2) < 700 && cursorY+(height/2) > 450))
    		 return true;
    	 else if((cursorY+(height/2) >= 600))
    		 return true;
    	 else if((cursorX+(width) >= 575))
    		 return true;
    	 else
    		 return false;
    }
    
}
