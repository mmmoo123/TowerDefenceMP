package model;

import java.awt.Image;

public abstract class Sprite {

    private Image image;
    private boolean dead;
    private boolean visible = true;

    protected int x;
    protected int y;
    protected int dx;
    protected int hp;

    public abstract void move();

    public Sprite(){
        this.dead = false;
    };

    public void die(){
        this.dead = true;
    }

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
}
