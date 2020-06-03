package model;

import images.ImageFactory;
import images.Image;
import javax.swing.*;
import java.io.Serializable;

public class FastBaloon extends Sprite implements Serializable {

	public FastBaloon(int x, int y){
        this.x = x;
        this.y = y;
        this.hp = 1;
        this.gold=10;
        this.dx = 5;
        this.line = 0;
        this.graphic = Image.B2;
    }
	
	@Override
	public int movePlayer2() {
		// TODO Auto-generated method stub
		return 0;
	}

}
