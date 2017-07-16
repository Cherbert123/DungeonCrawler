package lootPackage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends GameObject {
	String tactics;
	int health;
	Player p;
	boolean myTurn = false;
	boolean followPlayer = false;
	public static BufferedImage giantRatImg;
	public static BufferedImage kolblodFighterImg;
	int damage;
	int speed;
	int follow = 300;

	public Enemy(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		try {
			giantRatImg = ImageIO.read(this.getClass().getResourceAsStream("GiantRat.png"));
			kolblodFighterImg = ImageIO.read(this.getClass().getResourceAsStream("koboldFighter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void parseTactics(String t) {
		super.update();
		if (t.equalsIgnoreCase("Rage")) {
			if (p.x > x - follow && p.x < x + follow + 50 && p.y > y - follow && p.y < y + follow + 50) {
				followPlayer = true;
			} else {
				followPlayer = false;
				p.myTurn = true;
			}

			if (followPlayer == true) {
				if (p.x > x) {
					x = x + speed;
					p.myTurn = true;
				} else if (p.x < x) {
					x = x - speed;
					p.myTurn = true;
				}
				if (p.y > y) {
					y = y + speed;
					p.myTurn = true;
				} else if (p.y < y) {
					y = y - speed;
					p.myTurn = true;
				}
			}
			if (p.x > x - 50 && p.x < x + 50 + 50 && p.y > y - 50 && p.y < y + 50 + 50) {
				p.health = p.health - damage;
			} else {
			}
			p.myTurn = true;
			System.out.println(followPlayer + " Player: " + p.x);
		}
		collisionBox.setBounds(x, y, width, height);

	}

	/*
	 * public void parseAttack(String a){ if(a.equalsIgnoreCase("Ranged")){
	 * if(p.x < x + 200){ p.health = p.health - damage; } else if(p.x > x -
	 * 200){ p.health = p.health - damage; } else if(p.y < y + 200){ p.health =
	 * p.health - damage; } else if(p.y > y - 200){ p.health = p.health -
	 * damage; } else { System.out.println("Enemy Failed A Ranged attack!"); } }
	 * else if(a.equalsIgnoreCase("Melee")){ if(p.x < x + 50){ p.health =
	 * p.health - damage; } else if(p.x > x - 50){ p.health = p.health - damage;
	 * } else if(p.y < y + 50){ p.health = p.health - damage; } else if(p.y > y
	 * - 50){ p.health = p.health - damage; } else { System.out.println(
	 * "Enemy Failed A Melee Attack!"); } } else
	 * if(a.equalsIgnoreCase("ObjectThrow")){
	 * 
	 * } else if(a.equalsIgnoreCase("SpellCast")){
	 * 
	 * } }
	 */
	public void draw(Graphics g) {
		g.drawImage(giantRatImg, x, y, null);
	}
}
