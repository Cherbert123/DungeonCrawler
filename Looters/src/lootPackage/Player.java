package lootPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class Player extends GameObject{
	
int speed = 50;

int strength = 0;
int health;
int charisma;
int knowledge;
int nimbleness;
boolean myTurn = true;
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
		speed = 50 + nimbleness;
	}
	public void update(){
		super.update();
		speed = 50 + nimbleness;
		if(myTurn == true){
		if(up){
			y-=speed;
			myTurn = false;
		}
		if(down){
			y+=speed;
			myTurn = false;
		}
		if(right){
			x+=speed;
			myTurn = false;
		}
		if(left){
			x-=speed;
			myTurn = false;
		}
		if(y > 750){
			y = 750;
		}
		if(y < 5){
			y = 5;
		}
		if(x > 750){
			x = 750;
		}
		if(x < 0){
			x = 0;
		}	
		}
	}
	public void draw(Graphics g){
		g.drawImage(GamePanel.playerImg, x, y, width, height, null);
	}
	
}
