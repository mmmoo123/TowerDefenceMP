package model;

import java.awt.*;
import java.io.Serializable;

import images.Image;

public abstract class Sprite implements Serializable {

	int line;
    int dx;
	
    private boolean dead;
    private boolean visible = true;
    protected int gold;
    protected int x;
    protected int y;
   // protected int dx;
    protected int hp;
    protected Image graphic;
    
    public int move() {
    	 if (this.y <= 150 && line == 0) {
             this.y=this.y+dx;
         }
         if (this.y == 150 && this.x <= 160) {
             line = 1;
             this.x=this.x+dx;
         }
         if (this.x == 150 && line == 1) {
             this.y=this.y-dx;
         }
         if (this.y == 50 && this.x <= 400 && line == 1) {
             this.x=this.x+dx;
         }
         if (this.y <= 300 && this.x == 400) {
             this.y=this.y+dx;
         }
         if (this.y == 300 && this.x >= 250) {
             this.x=this.x-dx;
             line = 2;
         }
         if (this.x == 250 && this.y <= 450 && line == 2) {
             this.y=this.y+dx;
         }
         if (this.y == 450 && this.x >= 50) {
             this.x=this.x-dx;
             line = 3;
         }
         if (this.x == 50 && this.y < 700 && line == 3)
             this.y=this.y+dx;
         if (this.y == 700 && this.x < 600) {
             line = 0;
         }

         if(this.hp <= 0){
             this.setVisible(false);   
             return gold;
         }
         return 0;
    }
    
    public abstract int movePlayer2();

    public Sprite(){
        this.dead = false;
    };

    public void die(){
        this.dead = true;
    }

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

    public boolean isDead(){
        return this.dead;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public void dealDMG(int dmg){
        this.hp -= dmg;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public Image getImage(){
        return this.graphic;
    }
    
}
