package gra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gameplay extends JPanel implements KeyListener, MouseListener ,ActionListener, MouseMotionListener {
	public boolean play = false;
	public int player1HP = 100;
	public int player2HP = 100;
	
	private Timer timer;
	private int delay = 8;
	private int x;
	private int y;
	private int xpr=62;
	private int ypr=-50;
	private int line = 0;
	int[] lvlNavigationPointX = {50,50,150,150,400,400,250,250,50,50};
	int[] lvlNavigationPointY  = {-50,200,200,50,50,300,300,450,450,650};
	
	private BufferedImage mapa1;
	
	public Gameplay( ) {
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		File imageFile = new File("MapaTowerDefensa.png");
		try {
			mapa1 = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		Dimension dimension = new Dimension(mapa1.getWidth(), mapa1.getHeight());
		setPreferredSize(dimension);
		
	}
	
	public void paint(Graphics g) {
		// t³o
		//g.setColor(Color.black);
		//g.fillRect(1, 1, 1366, 768);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(mapa1, 0, 0, this);
		
		g.setColor(Color.black);
		g.fillRect(xpr, ypr, 30, 30);
		g.fillRect(xpr+650, ypr, 30, 30);
		
		g.dispose();
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		if(ypr <= 162 && line == 0)
		{
			ypr++;
		}
		if(ypr == 162 && xpr <= 158) {
			line=1;
			xpr++;
		}
		if(xpr == 158 && line == 1) {
			ypr--;
		}
		if(ypr == 62 && xpr <= 412 && line ==1) {
			xpr++;
		}
		if(ypr <= 312 && xpr == 412) {
			ypr++;
		}
		if(ypr == 312 && xpr >= 262) {
			xpr--;
			line = 2;
		}
		if(xpr == 262 && ypr <= 462 && line == 2) {
			ypr++;
		}
		if(ypr == 462 && xpr >= 62) {
			xpr--;
			line = 3;
		}
		if(xpr == 62 && ypr < 700 && line == 3)
			ypr++;
		if(ypr == 700) {
			xpr=62;
			ypr=-50;
			line = 0;
		}
			
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		ypr=ypr+1;
// 		points.add(new Point(x, y));
 		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		ypr=ypr+1;
 		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
	
}
