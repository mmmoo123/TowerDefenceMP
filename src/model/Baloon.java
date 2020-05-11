package model;

import images.Image;
import images.ImageFactory;

import javax.swing.*;

public class Baloon extends Sprite{


    int line=0;

    public Baloon(int x, int y){
        this.x = x;
        this.y = y;
        this.hp = 2;
        initialize();
    }

    private void initialize() {
        ImageIcon imageIcon = ImageFactory.createImage(Image.B1);
        setImage(imageIcon.getImage());

    }


    @Override
    public void move() {

            if (this.y <= 152 && line == 0) {
                this.y++;
            }
            if (this.y == 152 && this.x <= 158) {
                line = 1;
                this.x++;
            }
            if (this.x == 152 && line == 1) {
                this.y--;
            }
            if (this.y == 50 && this.x <= 400 && line == 1) {
                this.x++;
            }
            if (this.y <= 300 && this.x == 400) {
                this.y++;
            }
            if (this.y == 300 && this.x >= 250) {
                this.x--;
                line = 2;
            }
            if (this.x == 250 && this.y <= 450 && line == 2) {
                this.y++;
            }
            if (this.y == 450 && this.x >= 50) {
                this.x--;
                line = 3;
            }
            if (this.x == 50 && this.y < 700 && line == 3)
                this.y++;
            if (this.y == 700) {
                this.x = 50;
                this.y = -50;
                line = 0;
            }

            if(this.hp <= 0){
                this.setVisible(false);
            }
    }

}
