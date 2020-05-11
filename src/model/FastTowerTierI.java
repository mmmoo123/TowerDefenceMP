package model;

import images.Image;
import images.ImageFactory;

import javax.swing.*;
import java.util.List;

public class FastTowerTierI extends Tower{

    public FastTowerTierI(int x, int y){
        this.x = x;
        this.y = y;
        this.dmg = 1;
        this.coolDownAmount = 100;
        this.coolDown = 0;
        initialize();
    }

    private void initialize() {
        ImageIcon imageIcon = ImageFactory.createImage(Image.B1);
        setImage(imageIcon.getImage());

    }

    @Override
    public void shoot(List<Sprite> list) {

        coolDown--;

        if(this.coolDown <= 0){

            list.get(0).dealDMG(dmg);
            System.out.println("PifPaf");

            coolDown = coolDownAmount;
        }

    }
}
