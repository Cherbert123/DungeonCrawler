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
		if(t.equalsIgnoreCase("Snipe")){
			if(p.x < x + 200){
				x = x - speed;
			} else if(p.x > x - 200){
				x = x + speed;
			} else if(p.y < y + 200){
				y = y - speed;
			} else if(p.y > y - 200){
				y = y + speed;
			} else{
			//	parseAttack("Ranged");
				myTurn = false;
			}
		} else if(t.equalsIgnoreCase("Rage")){
			if(p.x < x + 200){
				x = x - speed;
				System.out.println(x);
				if(x >= 800 | x <= -50){
				x = x + speed;	
				
				}
			} else if(p.x > x - 200){
				x = x + speed;
				System.out.println(x);
				if(x >= 800 | x <= -50){
					x = x - speed;	
					
					}
			}
			if(p.y < y + 200){
				y = y - speed;
				System.out.println(y);
				if(y >= 800 | y <= 0){
					y = y + speed;	
					
					}
			} else if(p.y > y - 200){
				y = y + speed;
				if(y >= 800 | y <= 0){
					y = y - speed;	
					
					}
			} else {
				System.out.println("Enemy is Now Legally Blind");
			}
			//parseAttack("Melee");
			p.myTurn = true;
		} else if(t.equalsIgnoreCase("Wait")){
			
		} else if(t.equalsIgnoreCase("Engage")){
			if(p.x < x + 200){
				x = x + speed;
			} else if(p.x > x - 200){
				x = x - speed;
			} else if(p.y < y + 200){
				y = y + speed;
			} else if(p.y > y - 200){
				y = y - speed;
			}
			//parseAttack("Melee");
			p.myTurn = true;
		} else if(t.equalsIgnoreCase("HitAndRun")){
			if(p.x < x + 200){
				x = x + speed;
			} else if(p.x > x - 200){
				x = x - speed;
			} else if(p.y < y + 200){
				y = y + speed;
			} else if(p.y > y - 200){
				y = y - speed;
			} else {
				System.out.println("Enemy is Now Legally Blind");
			}
			//parseAttack("Melee");
			if(p.x < x + 50){
				x = x - speed;
				p.myTurn = true;
			} else if(p.x > x - 50){
				x = x + speed;
				p.myTurn = true;
			} else if(p.y < y + 50){
				y = y - speed;
				p.myTurn = true;
			} else if(p.y > y - 50){
				y = y + speed;
				p.myTurn = true;
			} else {
				System.out.println("Enemy Had No Where to Run To!");
			}			
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
