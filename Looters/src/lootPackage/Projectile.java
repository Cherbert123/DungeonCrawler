package lootPackage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Projectile extends GameObject{
	int rotation;
	int range;
	int x;
	int y;
	int width;
	int height;
	int movedSpaces;
	String img;
	public static BufferedImage fireImg;
	public static BufferedImage lightningImg;
public Projectile(String img, int rotation, int range, int x, int y, int width, int height){
	super();
	try {
		fireImg = ImageIO.read(this.getClass().getResourceAsStream("FireBlast.png"));
		lightningImg = ImageIO.read(this.getClass().getResourceAsStream("thunderShock.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	this.img = img;
	this.range = range;
	this.rotation = rotation;
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	
}
public void update(){
	super.update();
	if(movedSpaces < range){
		if(rotation == 0){
			y = y + 25;
		}
		if(rotation == 1){
			x = x + 25;
		}
		if(rotation == 2){
			y = y - 25;
		}
		if(rotation == 3){
			x = x - 25;
		}
	} else {
		x = x;
		y = y;
	}
}
public void draw(Graphics g){
	if(img.equalsIgnoreCase("fireImg")){
	g.drawImage(fireImg, x, y, null);
	}
	if(img.equalsIgnoreCase("lightningImg")){
	g.drawImage(lightningImg, x, y, null);
	}

}
}
