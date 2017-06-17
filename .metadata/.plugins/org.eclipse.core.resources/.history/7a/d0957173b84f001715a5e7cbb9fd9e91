package lootPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class Player extends GameObject{
	
int speed;

int strength;
int health;
int charisma;
int knowledge;
int nimbleness;
boolean up = false;
boolean down = false;
boolean right = false;
boolean left = false;
	public Player(int x, int y, int width, int height){
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 3;
	}
	public void update(){
		super.update();
		if(up){
			y-=speed;
		}
		if(down){
			y+=speed;
		}
		if(right){
			x+=speed;
		}
		if(left){
			x-=speed;
		}
		if(y > 725){
			y = 725;
		}
		if(y < 10){
			y = 10;
		}
		if(x > 730){
			x = 730;
		}
		if(x < 10){
			x = 10;
		}			
	}
	public void draw(Graphics g){
		g.drawImage(GamePanel.playerImg, x, y, width, height, null);
	}
	
}
