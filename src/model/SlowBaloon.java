package model;

import images.ImageFactory;
import images.Image;
import javax.swing.*;
import java.io.Serializable;

public class SlowBaloon extends Sprite implements Serializable{

	public SlowBaloon(int x, int y){
        this.x = x;
        this.y = y;
        this.hp = 5;
        this.gold=15;
        this.dx = 1;
        this.line = 0;
        this.graphic = Image.B3;
    }
	
	@Override
	public int movePlayer2() {
		// TODO Auto-generated method stub
		return 0;
	}

}
