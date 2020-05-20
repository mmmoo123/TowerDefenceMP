package model;

import java.awt.*;
import java.io.Serializable;
import java.util.List;
import images.Image;
import math.Calculation;

public abstract class Tower implements Serializable{

    protected int x;
    protected int y;
    protected int dmg;
    protected int coolDown;
    protected int coolDownAmount;
    protected int range;
    protected Image graphic;

    public void shoot(List<Sprite> list) {
    	coolDown--;
        if(this.coolDown <= 0) {
	        for(int i=0;i<list.size();i++) {
	        	if(list.get(i).isVisible()==true && Calculation.distance(this.x, this.y, 50, 50, list.get(i).x, list.get(i).y, 50, 50) < this.range){
	                list.get(i).dealDMG(dmg);
	              //  System.out.println("PifPaf");
	
	                coolDown = coolDownAmount;
	                break;
	            }
	        }
        }
    }

    public Tower(){
    };

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    
    public Image getImage(){
        return this.graphic;
    }
   
    public int GetRange(){
        return this.range;
    }

}
