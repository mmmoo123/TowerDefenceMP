package gra;


import com.dosse.upnp.UPnP;
import images.Image;
import images.ImageFactory;
import model.Baloon;
import model.FastBaloon;
import model.FastTowerTierI;
import model.ObszarTower;
import model.SlowBaloon;
import model.SlowTower;
import model.Sprite;
import model.Tower;
import siec.Communication;
import stale.Constants;
import gra.GameMainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import math.Calculation;

public class GamePanel extends JPanel implements KeyListener, MouseListener ,ActionListener, MouseMotionListener{
	protected int player1Gold = 100;
	public int player1Hp = 100;
	private int xMouse;
	private int yMouse;
    private ImageIcon mapaImage;
    private ImageIcon youLose;
    private ImageIcon youWinIcon;
    private ImageIcon interFaceBackGround;
    private ImageIcon FastTowerIcon;
    private ImageIcon SlowTowerIcon;
    private ImageIcon ObszarTowerIcon;
    private ImageIcon balonIcon;
    private ImageIcon slowBalonIcon;
    private ImageIcon fastBalonIcon;
    private Timer timer;
    private List<Sprite> player1baloonList;
    private List<Tower> player1towerList;
    private boolean isBuying;
	private boolean isSelling;
	private boolean isCursorON = false;
	private int showLose = 0;
	public boolean isHost;
	private int ticsToNewWave = 0;
	private int wave = 1;
	private int typeTower=1;
	public int buyedBaloons=0;
	public int youWin=0;
	Communication connection;
	GameState enemyGameState;
	ImageIcon imageIcon;
	public String ip;
	public String czyHost;
	GameState gameState;
	
    public GamePanel(){
        initializeVariables();
        initialize();
        initializeGame();
    }

    private void initializeGame() {
    	     
    }

    private void initializeVariables(){
    	isBuying = false;
		isSelling = false;
		
		ip = (String)JOptionPane.showInputDialog(null,"Podaj IP serwera", "IP serwera", JOptionPane.INFORMATION_MESSAGE, null, null, "127.0.0.1");
		if(ip==null)
			System.exit(0);
		czyHost = (String)JOptionPane.showInputDialog(null,"Czy jestes hostem. Jesli tak wpisz 'true', jeœli wpisz 'false'", "Host czy nie", JOptionPane.INFORMATION_MESSAGE, null, null, "true");
		
		
		UPnP.openPortUDP(7777);
		//Czy jestes hostem
				Scanner scan = new Scanner(System.in);
				//isHost = scan.nextBoolean();
				if(Objects.equals("true", czyHost))
					isHost = true;
				else if(Objects.equals("false", czyHost))
					isHost = false;
				try {
					connection = new Communication(7777,ip, isHost);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		
		
        this.player1baloonList = new ArrayList<>();
        this.player1towerList = new ArrayList<>();
        this.mapaImage = ImageFactory.createImage(Image.MAPA);
        this.youLose = ImageFactory.createImage(Image.YouLose);
        this.youWinIcon = ImageFactory.createImage(Image.YouWin);
        this.interFaceBackGround = ImageFactory.createImage(Image.InterfaceBackground);
        this.FastTowerIcon = ImageFactory.createImage(Image.T1icon);
        this.SlowTowerIcon = ImageFactory.createImage(Image.T2icon);
        this.ObszarTowerIcon = ImageFactory.createImage(Image.T3icon);
        this.balonIcon = ImageFactory.createImage(Image.B1icon);
        this.slowBalonIcon = ImageFactory.createImage(Image.B2icon);
        this.fastBalonIcon = ImageFactory.createImage(Image.B3icon);
        
        this.timer = new Timer(Constants.GAME_SPEED,new GameLoop(this));
        this.timer.start();
        
    }

    private void initialize() {
    	addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);

        setFocusable(true);
        setPreferredSize(new Dimension(Constants.WINDNOW_WIDTH, Constants.WINDNOW_HEIGHT));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mapaImage.getImage(), 0, 0, null);
        for(Sprite baloon : this.player1baloonList) {
            if(baloon.isVisible()) {
				imageIcon = ImageFactory.createImage(baloon.getImage());
				g.drawImage(imageIcon.getImage(), baloon.getX(), baloon.getY(), this);
			}
        }

        for(Sprite baloonOpponent : enemyGameState.getBaloonList()) {
            if(baloonOpponent.isVisible()) {
				imageIcon = ImageFactory.createImage(baloonOpponent.getImage());
				g.drawImage(imageIcon.getImage(), baloonOpponent.getX(), baloonOpponent.getY(), this);
			}
        }
        
        for(Tower tower : this.player1towerList) {
    		imageIcon = ImageFactory.createImage(tower.getImage());
            g.drawImage(imageIcon.getImage(), tower.getX(), tower.getY(), this);
            g.drawOval(tower.getX()-tower.GetRange()+25, tower.getY()-tower.GetRange()+25, tower.GetRange()*2, tower.GetRange()*2);
        }

        for(Tower tower : enemyGameState.getTowerList()) {
			imageIcon = ImageFactory.createImage(tower.getImage());
            g.drawImage(imageIcon.getImage(), tower.getX(), tower.getY(), this);
            g.drawOval(tower.getX()-100+25, tower.getY()-100+25, 200, 200);
    	}
       
        g.drawImage(interFaceBackGround.getImage(), 0, 0, null);
        g.drawImage(FastTowerIcon.getImage(), 25, 650, null);
        g.drawImage(SlowTowerIcon.getImage(), 25, 725, null);
        g.drawImage(ObszarTowerIcon.getImage(), 100, 650, null);
        g.drawImage(balonIcon.getImage(), 300, 650, null);
        g.drawImage(slowBalonIcon.getImage(), 300, 725, null);
        g.drawImage(fastBalonIcon.getImage(), 375, 650, null);

        if(typeTower==1 && isBuying && isCursorON==false)
        	g.drawImage(FastTowerIcon.getImage(), xMouse-25, yMouse-25, null);
        if(typeTower==2 && isBuying && isCursorON==false)
        	g.drawImage(SlowTowerIcon.getImage(), xMouse-25, yMouse-25, null);
        if(typeTower==3 && isBuying && isCursorON==false)
        	g.drawImage(ObszarTowerIcon.getImage(), xMouse-25, yMouse-25, null);
        Color myWhite = new Color(255, 0, 0);
        g.setColor(myWhite);
        g.drawString("HP: "+ player1Hp, 0, 610);
        g.drawString("GOLD: "+ player1Gold, 0, 620);
        if(isBuying)
        	g.drawString("Kupujesz", 0, 630);
        if(isSelling)
        	g.drawString("Sprzedajesz", 0, 630);
        
        if(showLose == 1)
        	g.drawImage(youLose.getImage(), Constants.youLoseX, Constants.youLoseY, null);
        if(youWin == 1)
        	g.drawImage(youWinIcon.getImage(), Constants.youLoseX, Constants.youLoseY, null);
        	
        
    }

    public void doneLoop() {

    	if(player1Hp > 0 && youWin==0) {
        update();
        repaint();
    	}
    	else {
    		if(youWin==0) {
    			showLose = 1;
        		repaint();
    		}
    		else {
    			repaint();
    		}
    			
    	}
    		
    		
    }

    private void update() {

    	if(ticsToNewWave==1000) {
    		ticsToNewWave=0;
    		wave++;
    	}
    		
    	if(ticsToNewWave==0) {
    		for(int i=0; i<5*wave;i++) {
               
                	
                	
            		SlowBaloon slowbaloon = new SlowBaloon(50,-50-(50*i));
                	this.player1baloonList.add(slowbaloon);
            	      	
            	
                	Baloon baloon = new Baloon(50,-50-(50*i));
                	this.player1baloonList.add(baloon);
                           	
                
                	FastBaloon fastBaloon = new FastBaloon(50,-50-(50*i));
                	this.player1baloonList.add(fastBaloon);
                
                	
            }
    	}
    	
    		
    	ticsToNewWave++;	
    	//System.out.println(ticsToNewWave);
        for(Sprite baloon : this.player1baloonList) {
            if(baloon.isVisible()) {
            	player1Gold+=baloon.move();
            	if(baloon.getY() == 600)
            		player1Hp=player1Hp-2;
            }
        }          
         
        for(Tower tower : this.player1towerList) {
        	tower.shoot(player1baloonList);        	
        }
        
        for(Sprite baloon : this.player1baloonList) {
    		if(baloon.getY() >= 700 || !baloon.isVisible()) {
    			this.player1baloonList.remove(baloon);
    			break;
    		}
    			
    	}

       // Czêœæ sieciowa
		gameState = new GameState(player1Hp, player1baloonList, player1towerList, buyedBaloons);
		buyedBaloons = 0;

        if(isHost)
        {
        	
			try {
				enemyGameState = connection.reciveGameState();
				connection.sendGameState(gameState);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		}
        else
		{
			try {
				connection.sendGameState(gameState);
				enemyGameState = connection.reciveGameState();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	
		}

		enemyGameState.addOfset();

        switch (enemyGameState.getBuyBaloon()){

			case 1:
				for(int i = 0; i < 5; i++){
					Baloon baloon = new Baloon(50,-50-(50*i));
					this.player1baloonList.add(baloon);
				}
				break;
			case 2:
				for(int i = 0; i < 5; i++){
					FastBaloon fastBaloon = new FastBaloon(50,-50-(50*i));
					this.player1baloonList.add(fastBaloon);
				}
				break;
			case 3:
				for(int i = 0; i < 5; i++){
					SlowBaloon slowbaloon = new SlowBaloon(50,-50-(50*i));
					this.player1baloonList.add(slowbaloon);
				}
				break;
			default:
				break;
		}

		//System.out.println("You WIN = "+ youWin );
		if(ticsToNewWave>1) {
			if(enemyGameState.getPlayerHp()<=0)
				youWin=1;
			System.out.println("HP WROGA = " + enemyGameState.getPlayerHp() );
		}
        
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_1) {
			isBuying = true;
			isSelling = false;
			System.out.println("KUPUJE");
		}
		if(e.getKeyCode() == KeyEvent.VK_2) {
			isBuying = false;
			isSelling = true;
			System.out.println("SPRZEDAJE");
		}
		if(e.getKeyCode() == KeyEvent.VK_Q) {
			typeTower = 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			typeTower = 2;
		}
		if(e.getKeyCode() == KeyEvent.VK_E) {
			typeTower = 3;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {

			if(player1Gold >= 50 && buyedBaloons == 0) {

				buyedBaloons = 1;
				player1Gold = player1Gold - 50;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {

			if(player1Gold >= 200 && buyedBaloons == 0) {

				buyedBaloons = 3;
				player1Gold = player1Gold - 200;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {

			if(player1Gold >= 100 && buyedBaloons == 0) {

				buyedBaloons = 2;
				player1Gold = player1Gold - 100;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
		isCursorON= Calculation.collisionWithRoad(e.getX(), e.getY(), 50, 50, 0) && this.player1towerList.isEmpty();
		for(Tower tower : this.player1towerList) {
			if(Calculation.collision(Calculation.distance(e.getX(), e.getY(), 0, 0, tower.getX(), tower.getY(), 50, 50)) || Calculation.collisionWithRoad(e.getX(), e.getY(), 50, 50, 0)) {
				isCursorON=true;
				break;
			}
			else {
				isCursorON=false;				
			}
		}		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(isBuying==true && e.getX() <= 600) {
			
			if(isCursorON==false && player1Gold >=50) {
				if(typeTower==1) {
					player1towerList.add(new FastTowerTierI(e.getX()-25,e.getY()-25));
					player1Gold=player1Gold-50;
					isCursorON=true;
				}
				else if(typeTower==2 && player1Gold >=100) {
					player1towerList.add(new SlowTower(e.getX()-25,e.getY()-25));
					player1Gold=player1Gold-100;
					isCursorON=true;
				}
				else if(typeTower==3 && player1Gold >=150) {
					player1towerList.add(new ObszarTower(e.getX()-25,e.getY()-25));
					player1Gold=player1Gold-150;
					isCursorON=true;
				}
			}
		}
		
		if(isSelling==true && e.getX() <= 600 && isCursorON==true) {			
				for(Tower tower : this.player1towerList) {
					if(Calculation.distance(e.getX(), e.getY(), 0, 0, tower.getX(), tower.getY(), 50, 50) < 50 && isCursorON==true) { 
						player1towerList.remove(tower);
						
						break;
					}					
				}
			isCursorON=true;			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
