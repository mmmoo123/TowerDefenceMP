package gra;

import java.awt.*;
import java.io.IOException;

public class App {
    public static void main(String[] args)  {

        EventQueue.invokeLater( () ->{
            new GameMainFrame();
        });
    }
}
