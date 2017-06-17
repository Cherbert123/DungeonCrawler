package lootPackage;

public class Enemy {
	GamePanel panel = new GamePanel();
	String tactics;
	int health;
	int x;
	int y;
	int speed;
	public Enemy(){
		if(panel.myTurn == false){
			parseTactics(tactics);
		}
	}
	public void parseTactics(String t){
		if(t.equalsIgnoreCase("Snipe")){
			if(panel.player.x < x + 200){
				x = x - speed;
			} else if(panel.player.x > x - 200){
				x = x + speed;
			} else if(panel.player.y < y + 200){
				y = y - speed;
			} else if(panel.player.y > y - 200){
				y = y + speed;
			} else{
				parseAttack("Ranged");
				panel.myTurn = true;
			}
		} else if(t.equalsIgnoreCase("Rage")){
			if(panel.player.x < x + 200){
				x = x + speed;
			} else if(panel.player.x > x - 200){
				x = x - speed;
			} else if(panel.player.y < y + 200){
				y = y + speed;
			} else if(panel.player.y > y - 200){
				y = y - speed;
			}
			parseAttack("Melee");
			panel.myTurn = true;
		} else if(t.equalsIgnoreCase("Wait")){
			
		} else if(t.equalsIgnoreCase("Engage")){
			if(panel.player.x < x + 200){
				x = x + speed;
			} else if(panel.player.x > x - 200){
				x = x - speed;
			} else if(panel.player.y < y + 200){
				y = y + speed;
			} else if(panel.player.y > y - 200){
				y = y - speed;
			}
			parseAttack("Melee");
			panel.myTurn = true;
		} else if(t.equalsIgnoreCase("HitAndRun")){
			if(panel.player.x < x + 200){
				x = x + speed;
			} else if(panel.player.x > x - 200){
				x = x - speed;
			} else if(panel.player.y < y + 200){
				y = y + speed;
			} else if(panel.player.y > y - 200){
				y = y - speed;
			}
			parseAttack("Melee");
			if(panel.player.x < x + 50){
				x = x - speed;
				panel.myTurn = true;
			} else if(panel.player.x > x - 50){
				x = x + speed;
				panel.myTurn = true;
			} else if(panel.player.y < y + 50){
				y = y - speed;
				panel.myTurn = true;
			} else if(panel.player.y > y - 50){
				y = y + speed;
				panel.myTurn = true;
			}
			
		}
		
	}
	public void parseAttack(String a){
		if(a.equalsIgnoreCase("Ranged")){
			
		} else if(a.equalsIgnoreCase("Melee")){
			
		} else if(a.equalsIgnoreCase("ObjectThrow")){
			
		} else if(a.equalsIgnoreCase("SpellCast")){
			
		}
	}
}
