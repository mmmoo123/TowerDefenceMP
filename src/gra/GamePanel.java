package gra;


import images.Image;
import images.ImageFactory;
import stale.Constants;

import javax.swing.*;
import java.awt.*;



public class GamePanel extends JPanel {

	private ImageIcon mapaImage;
	private Timer timer;

	
    public GamePanel(){
    	initializeVariables();
        initialize();
    }

    private void initializeVariables() {

        this.mapaImage = ImageFactory.createImage(Image.MAPA);
        this.timer = new Timer(Constants.GAME_SPEED,new GameLoop(this));
        this.timer.start();
	}

	private void initialize() {
        setPreferredSize(new Dimension(Constants.WINDNOW_WIDTH, Constants.WINDNOW_HEIGHT));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	g.drawImage(mapaImage.getImage(), 0, 0, null);
    }

    public void doOneLoop() {
        update();
        repaint();
    }

    private void update() {
        System.out.println("Update");
    }
}
