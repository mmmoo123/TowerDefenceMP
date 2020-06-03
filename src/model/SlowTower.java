package model;

import images.Image;
import images.ImageFactory;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;
import math.Calculation;

public class SlowTower extends Tower implements Serializable{
	public SlowTower(int x, int y){
        this.x = x;
        this.y = y;
        this.dmg = 3;
        this.range = 200;
        this.coolDownAmount = 50;
        this.coolDown = 0;
        graphic = Image.T2;
        
    }
}
