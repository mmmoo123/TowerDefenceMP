package model;

import images.ImageFactory;
import images.Image;
import javax.swing.*;

public class Baloon extends Sprite{

    public Baloon(int x, int y){
        this.x = x;
        this.y = y;
        this.hp = 2;
        this.gold=5;
        this.dx = 2;
        this.line = 0;
        this.graphic = Image.B1;
    }
 
    @Override
    public int movePlayer2() {

        if (this.y <= 150 && line == 0) {
            this.y=this.y+dx;
        }
        if (this.y == 150 && this.x <= 800) {
            line = 1;
            this.x=this.x+dx;
        }
        if (this.x == 800 && line == 1) {
            this.y=this.y-dx;
        }
        if (this.y == 50 && this.x <= 1050 && line == 1) {
            this.x=this.x+dx;
        }
        if (this.y <= 300 && this.x == 1050) {
            this.y=this.y+dx;
        }
        if (this.y == 300 && this.x >= 900) {
            this.x=this.x-dx;
            line = 2;
        }
        if (this.x == 900 && this.y <= 450 && line == 2) {
            this.y=this.y+dx;
        }
        if (this.y == 450 && this.x >= 700) {
            this.x=this.x-dx;
            line = 3;
        }
        if (this.x == 700 && this.y < 700 && line == 3)
            this.y=this.y+dx;
        if (this.y == 700 && this.x > 600) {
            line = 0;
        }

        if(this.hp <= 0){
            this.setVisible(false);   
            return gold;
        }
        return 0;
}
    

}
