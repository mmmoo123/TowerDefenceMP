package gra;

import stale.Constants;

import javax.swing.*;

import images.Image;
import images.ImageFactory;

public class GameMainFrame extends JFrame {
    public GameMainFrame(){
        initializeLayout();
    }

    private void initializeLayout() {

        add(new GamePanel());

        setTitle(Constants.TITLE);
        setIconImage(ImageFactory.createImage(Image.IKONA).getImage());
        
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
