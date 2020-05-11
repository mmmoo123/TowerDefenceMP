package gra;


import images.Image;
import images.ImageFactory;
import model.Baloon;
import model.FastTowerTierI;
import model.Sprite;
import model.Tower;
import stale.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GamePanel extends JPanel {

    private ImageIcon mapaImage;
    private Timer timer;
    private List<Sprite> baloonList;
    private Tower tower;

    public GamePanel(){
        initializeVariables();
        initialize();
        initializeGame();
    }

    private void initializeGame() {
        for(int i=0; i<40;i++) {
            Baloon baloon = new Baloon(50,-50-(50*i));
            this.baloonList.add(baloon);
        }

        tower = new FastTowerTierI(250,100);
    }

    private void initializeVariables() {
        this.baloonList = new ArrayList<>();


        this.mapaImage = ImageFactory.createImage(Image.MAPA);
        this.timer = new Timer(Constants.GAME_SPEED,new GameLoop(this));
        this.timer.start();
    }

    private void initialize() {
        setFocusable(true);
        setPreferredSize(new Dimension(Constants.WINDNOW_WIDTH, Constants.WINDNOW_HEIGHT));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(mapaImage.getImage(), 0, 0, null);
        for(Sprite baloon : this.baloonList) {
            if(baloon.isVisible())
                g.drawImage(baloon.getImage(), baloon.getX(), baloon.getY(), this);
        }

        g.drawImage(tower.getImage(),tower.getX(),tower.getY(),this);

    }

    public void doneLoop() {
        update();
        repaint();
    }

    private void update() {
        for(Sprite baloon : this.baloonList) {
            if(baloon.isVisible())
                baloon.move();


            //System.out.println("Update");
        }

        tower.shoot(baloonList);
    }
}
