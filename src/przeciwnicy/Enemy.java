package przeciwnicy;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

public class Enemy extends Applet {

    int x;
    int y;

    public Enemy(){
        x = 5;
        y = 5;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 50, 50);
    }
}
