package lootPackage;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer framerate;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int PLAYERC_STATE = 6;
	int currentState = MENU_STATE;
	public static BufferedImage logoImg;
	public static BufferedImage menuBackgroundImg;
	public static BufferedImage subLogo;
	public static BufferedImage woodenWallImg;
	Player player = new Player();

	
	public GamePanel(){
		framerate = new Timer(1000/60, this);
		try {
			logoImg = ImageIO.read(this.getClass().getResourceAsStream("Logo.png"));
			menuBackgroundImg = ImageIO.read(this.getClass().getResourceAsStream("MenuBackGround.jpg"));
			subLogo = ImageIO.read(this.getClass().getResourceAsStream("Sublogo.png"));
			woodenWallImg = ImageIO.read(this.getClass().getResourceAsStream("WoodenWall.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
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

		
	}
	private void updateEndState() {

		
	}
// Key Handler Methods
	@Override
	public void keyPressed(KeyEvent e) {
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
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {

		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {

		
	}
// Draw Methods
	public void drawMenuState(Graphics g){
		g.drawImage(menuBackgroundImg, 0, 0, null);
		g.drawImage(logoImg, 75, 200, null);
		g.drawImage(subLogo, 140, 400, null);
	}
	private void drawPlayerCState(Graphics g) {
		g.drawImage(woodenWallImg, 0, 0, null);
		

		
	}
	private void drawEndState(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	private void drawGameState(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
