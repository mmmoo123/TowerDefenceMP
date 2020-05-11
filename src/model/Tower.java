package model;

import java.awt.*;
import java.util.List;

public abstract class Tower {

    private Image image;

    protected int x;
    protected int y;
    protected int dmg;
    protected int coolDown;
    protected int coolDownAmount;
    protected int range;

    public abstract void shoot(List<Sprite> list);

    public Tower(){

    };


    public void setImage(Image image){
        this.image = image;
    }

    public Image getImage(){
        return this.image;
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

}
