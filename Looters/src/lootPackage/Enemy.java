package lootPackage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends GameObject{
	String tactics;
	int health;
	Player p;
	boolean myTurn = false;
	boolean followPlayer = false;
	int x;
	int y;
	public static BufferedImage giantRatImg;
	int damage;
	int speed;
	public Enemy(){
		try {
			giantRatImg = ImageIO.read(this.getClass().getResourceAsStream("GiantRat.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public void parseTactics(String t){
	
		 if(t.equalsIgnoreCase("Rage")){
			if(p.x > x - 150 && p.x < x + 200 && p.y > y - 150 && p.y < y + 200){
				followPlayer = true;
			} else {
				followPlayer = false;
			}
			
			if(followPlayer == true){
				if (p.x > x) {
					x = x + speed; 
				} else if (p.x < x) {
					x = x - speed; 
				}
				if (p.y > y) {
					y = y + speed; 
				} else if (p.y < y) {
					y = y - speed; 
				}
			}
			p.myTurn = true;
			System.out.println(followPlayer + " Player: " + p.x);
		} 

	}
/*	public void parseAttack(String a){
		if(a.equalsIgnoreCase("Ranged")){
			if(p.x < x + 200){
				p.health = p.health - damage;
			} else if(p.x > x - 200){
				p.health = p.health - damage;
			} else if(p.y < y + 200){
				p.health = p.health - damage;
			} else if(p.y > y - 200){
				p.health = p.health - damage;
			} else {
				System.out.println("Enemy Failed A Ranged attack! Maybe they should head back to the barracks?");
			}
		} else if(a.equalsIgnoreCase("Melee")){
			if(p.x < x + 50){
				p.health = p.health - damage;
			} else if(p.x > x - 50){
				p.health = p.health - damage;
			} else if(p.y < y + 50){
				p.health = p.health - damage;
			} else if(p.y > y - 50){
				p.health = p.health - damage;
			} else {
				System.out.println("Enemy Attempted to Poke You. It Failed");
			}
		} else if(a.equalsIgnoreCase("ObjectThrow")){
			
		} else if(a.equalsIgnoreCase("SpellCast")){
			
		}
	} */
	public void draw(Graphics g){
		g.drawImage(giantRatImg, x, y, null);
	}
}
