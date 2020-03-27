import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Main extends Canvas implements Runnable {

    //Stałe
    final int WIDTH = 1280;
    final int HEIGHT = 960;
    //Zmienne
    int port = 7777;
    boolean isServer;
    boolean runnig = false;
    int tickCount = 0;
    JFrame frame;

    public Main(){
        //Połączenie
        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("Stworzyć serwer?");
        isServer = scan.nextBoolean();

        if(isServer){
            HostServer hs = new HostServer(port);
        }
        else{
            JoinServer js = new JoinServer(port);
        }
        */
        //Okno
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        setMaximumSize(new Dimension(WIDTH,HEIGHT));
        setPreferredSize(new Dimension(WIDTH,HEIGHT));

        frame = new JFrame("Tower Defence MP");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this,BorderLayout.CENTER);
        frame.pack();

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void startGame() {
        runnig = true;
        new Thread(this).start();
    }

    public void stopGame() {
        runnig = false;
    }

    public void tick(){
        tickCount++;
    }

    public void render(){

    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000.0/60.0;

        int frames = 0;
        int ticks = 0;

        long lasTimer = System.currentTimeMillis();
        double delta = 0;

        while(runnig){
            boolean shouldRender = true;
            long now = System.nanoTime();
            delta += (now - lastTime)/nsPerTick;
            lastTime = now;

            while(delta >= 1) {
                ticks++;
                tick();
                delta -= 1;
                shouldRender = true;
            }

            if(shouldRender) {
                frames++;
                render();
            }
            if(System.currentTimeMillis() - lasTimer > 1000){
                lasTimer += 1000;
                System.out.println(frames+" "+ticks);
                frames = 0;
                ticks = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Main().startGame();
    }
}
