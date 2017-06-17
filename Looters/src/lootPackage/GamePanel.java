package lootPackage;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer framerate;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int PLAYERC_STATE = 6;
	int currentState = MENU_STATE;
	int statPoints = 35;
	public static BufferedImage logoImg;
	public static BufferedImage menuBackgroundImg;
	public static BufferedImage subLogo;
	public static BufferedImage woodenWallImg;
	public static BufferedImage solidFloorTile;
	public static BufferedImage waterFloorTile;
	public static BufferedImage plusImg;
	public static BufferedImage minusImg;
	public static BufferedImage blockedFloorTile;
	public static BufferedImage playerImg;
	Font normal;
	JButton plusStrength = new JButton("+");
	JButton minusStrength = new JButton("-");
	JButton plusSpeed = new JButton("+");
	JButton minusSpeed = new JButton("-");
	boolean inventory = false;
	int yTile = 0;
	int xTile = 0;
	int rand;
	public String room = "";
	ObjectManager om = new ObjectManager();
	Player player = new Player(400,750,50,50);
	
	
	public GamePanel(){
		plusSpeed.setFocusable(false);
		minusSpeed.setFocusable(false);
		plusStrength.setFocusable(false);
		minusStrength.setFocusable(false);
		normal = new Font("Arial",Font.PLAIN,35);
		framerate = new Timer(1000/60, this);
		om.addObject(player);
		setLayout(null);
		plusStrength.setBounds(new Rectangle(700,85,45,45));
		minusStrength.setBounds(new Rectangle(600,85,45,45));
		plusStrength.setEnabled(false);
		plusStrength.setVisible(false);
		minusStrength.setEnabled(false);
		minusStrength.setVisible(false);
		plusStrength.addActionListener(this);
		minusStrength.addActionListener(this);
		plusSpeed.setBounds(new Rectangle(700,535,45,45));
		minusSpeed.setBounds(new Rectangle(600,535,45,45));
		plusSpeed.setEnabled(false);
		plusSpeed.setVisible(false);
		minusSpeed.setEnabled(false);
		minusSpeed.setVisible(false);
		plusSpeed.addActionListener(this);
		minusSpeed.addActionListener(this);
		add(minusStrength);
		add(plusStrength);
		add(minusSpeed);
		add(plusSpeed);
		try {
			logoImg = ImageIO.read(this.getClass().getResourceAsStream("Logo.png"));
			menuBackgroundImg = ImageIO.read(this.getClass().getResourceAsStream("MenuBackGround.jpg"));
			subLogo = ImageIO.read(this.getClass().getResourceAsStream("Sublogo.png"));
			woodenWallImg = ImageIO.read(this.getClass().getResourceAsStream("WoodenWall.jpg"));
			playerImg = ImageIO.read(this.getClass().getResourceAsStream("Player.png"));
			solidFloorTile = ImageIO.read(this.getClass().getResourceAsStream("solidFloorTile.png"));
			waterFloorTile = ImageIO.read(this.getClass().getResourceAsStream("waterFloorTile.png"));
			blockedFloorTile = ImageIO.read(this.getClass().getResourceAsStream("blockedFloorTile.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
	}
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}
		if(e.getSource() == plusStrength){
			if(statPoints > 0){
				System.out.println(statPoints);
			player.strength = player.strength + 1;
			statPoints = statPoints - 1;
			}
		}
		if(e.getSource() == minusStrength){
			if(player.strength > 0){
			player.strength = player.strength - 1;
			statPoints = statPoints + 1;
			}
		}
		if(e.getSource() == plusSpeed){
			if(statPoints > 0){
				System.out.println(statPoints);
			player.nimbleness = player.nimbleness + 1;
			statPoints = statPoints - 1;
			}
		}
		if(e.getSource() == minusSpeed){
			if(player.nimbleness > 0){
			player.nimbleness = player.nimbleness - 1;
			statPoints = statPoints + 1;
			}
		}
	}
	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}else if(currentState == PLAYERC_STATE){
			drawPlayerCState(g);
		}
		}
	
	public void startGame(){
		framerate.start();
	}
// Update Methods
	private void updateMenuState() {

		
	}
	private void updateGameState() {
		om.update();
		
	}
	private void updateEndState() {

		
	}
// Key Handler Methods
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e);
		if(e.getKeyCode() == 10){
			if(currentState == END_STATE){
				currentState = MENU_STATE;
			} else if(currentState == MENU_STATE){
				currentState = PLAYERC_STATE;
			} else if(currentState == GAME_STATE){
				currentState = MENU_STATE;
			} else if(currentState == PLAYERC_STATE){
				currentState = GAME_STATE;
			}
		}
		if(e.getKeyCode() == 39){
			player.right = true;
			player.update();
		}
		if(e.getKeyCode() == 37){
			player.left = true;
			player.update();
		}
		if(e.getKeyCode() == 38){
			player.up = true;
			player.update();
		}
		if(e.getKeyCode() == 40){
		player.down = true;
		player.update();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 39){
			player.right = false;
			player.update();
		}
		if(e.getKeyCode() == 37){
			player.left = false;
			player.update();
		}
		if(e.getKeyCode() == 38){
			player.up = false;
			player.update();
		}
		if(e.getKeyCode() == 40){
		player.down = false;
		player.update();
		}
	
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {

		
	}
// Draw Methods
	public void drawMenuState(Graphics g){
		g.drawImage(menuBackgroundImg, 0, 0, null);
		g.drawImage(logoImg, 75, 200, null);
		g.drawImage(subLogo, 140, 400, null);
		plusStrength.setEnabled(false);
		plusStrength.setVisible(false);
		minusStrength.setEnabled(false);
		minusStrength.setVisible(false);
		minusSpeed.setEnabled(false);
		minusSpeed.setVisible(false);
		plusSpeed.setEnabled(false);
		plusSpeed.setVisible(false);
	}
	private void drawPlayerCState(Graphics g) {
		g.drawImage(woodenWallImg, 0, 0, null);
		g.drawImage(GamePanel.playerImg, 50, 175, 450, 475, null);
		plusStrength.setEnabled(true);
		plusStrength.setVisible(true);
		minusStrength.setEnabled(true);
		minusStrength.setVisible(true);
		minusSpeed.setEnabled(true);
		minusSpeed.setVisible(true);
		plusSpeed.setEnabled(true);
		plusSpeed.setVisible(true);
		g.setColor(Color.BLACK);
		g.setFont(normal);
		g.drawString("" + player.strength, 660, 120);
		g.drawString("" + player.nimbleness, 660, 570);
		
		
	}
	private void drawEndState(Graphics g) {
		// TODO Auto-generated method stub
		plusStrength.setEnabled(false);
		plusStrength.setVisible(false);
		minusStrength.setEnabled(false);
		minusStrength.setVisible(false);
		minusSpeed.setEnabled(false);
		minusSpeed.setVisible(false);
		plusSpeed.setEnabled(false);
		plusSpeed.setVisible(false);
	}
	
	private void drawGameState(Graphics g) {
		plusStrength.setEnabled(false);
		plusStrength.setVisible(false);
		minusStrength.setEnabled(false);
		minusStrength.setVisible(false);
		minusSpeed.setEnabled(false);
		minusSpeed.setVisible(false);
		plusSpeed.setEnabled(false);
		plusSpeed.setVisible(false);
	xTile = 0;
	yTile = 0;
	for (int e = 0; e < 16; e++) {
	
		for (int i = 0; i < 16; i++) {

			if (room.charAt(xTile) == '1') {
				g.drawImage(solidFloorTile, i * 50, yTile, null);
				
			}  else if (room.charAt(xTile) == '2') {
				g.drawImage(waterFloorTile, i * 50, yTile, null);

			} else if (room.charAt(xTile) == '3') {
				g.drawImage(blockedFloorTile, i * 50, yTile, null);
		
			}
			xTile++;
			
	}
		yTile = yTile + 50;
	}
		om.draw(g);
	}
	public void generate(){
		Random random = new Random();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (rand == 1) {
					room = room + "1";
				} else if(rand == 0){
					rand = random.nextInt(3);
					if( rand > 1){
						room = room + "1";
					} else if(rand <= 1){
					
						room = room + "2";
					}
				} else if (rand == 2) {
					rand = random.nextInt(3);
					if( rand <= 1){
						room = room + "1";
					} else if(rand > 1){
					
						rand = random.nextInt(3);
						if( rand <= 1){
							room = room + "1";
						} else if(rand > 1){
						
							room = room + "3";
						}
					}
				}
				rand = random.nextInt(3);
						
			}
	
		}
		System.out.println(room);
		
	}
	
}