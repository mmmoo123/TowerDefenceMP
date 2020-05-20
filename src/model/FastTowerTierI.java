package model;

import images.Image;
import images.ImageFactory;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;
import math.Calculation;

public class FastTowerTierI extends Tower implements Serializable{

    public FastTowerTierI(int x, int y){
        this.x = x;
        this.y = y;
        this.dmg = 1;
        this.range = 100;
        this.coolDownAmount = 25;
        this.coolDown = 0;
        graphic = Image.T1;
        
    }

}
