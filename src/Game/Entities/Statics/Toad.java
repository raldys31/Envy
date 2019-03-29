package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Game.World.InWorldAreas.TownArea;
import Main.GameSetUp;
import Main.Handler;
import Resources.Images;

public class Toad extends BaseStaticEntity {
	
	Rectangle collision;
	int width, height;
	private int index=0;
	private int index2=0;
	private int count;
	public static boolean completedQuest = false, selectedQuests =false;
	
	public Toad(Handler handler, int xPosition, int yPosition) {
		super(handler, xPosition, yPosition);
		width = 100;
		height = 100;
		
		this.setXOffset(xPosition);
		this.setYOffset(yPosition);
		
		collision = new Rectangle();
	}
	
	
	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(TownArea.isInTown) {
			g.drawImage(Images.toad, (int)(handler.getXInWorldDisplacement() + xPosition),
					(int)( handler.getYInWorldDisplacement() + yPosition), width, height, null);
			collision = new Rectangle((int)(handler.getXInWorldDisplacement() + xPosition - 20), 
					(int)(handler.getYInWorldDisplacement() + yPosition), width+70, height+100);
			if (GameSetUp.DEBUGMODE) {
				g2.draw(getCollision());
			}
			checkCollision();
			//checkIfSelectedQuest();
			checkQuest();
		}
		
	}

	private void checkCollision() {
		int selected;
		if(inArea() && count==3) {
			count=0;
			if(!completedQuest) {
				selected = this.handler.showOptionMessage("Do you want to get a skill?", "Quest", Images.toadIcon);
				if(selected == 0) {
					this.handler.showMessage("Defeat an enemy on this town.", "Quest", Images.toadIcon);
					selectedQuests=true;
				}
				move();
			}

			if(completedQuest&&index==0) {
				this.handler.showMessage("You gained IceSkill.", "Quest Completed.", Images.toadIcon);
				move();
				index=1;
			}
		}
		else if(inArea()&&count<3){
			count++;
		}
	}
	
	private void checkIfSelectedQuest() {
		if(inArea() && count==3) {
			count=0;
			if(selectedQuests && !completedQuest) {
				this.handler.showMessage("Complete the quest!!", "Quest", Images.toadIcon);
				move();
			}
		}
		else if(inArea()&&count<3){
			count++;
		}
	}
	
	private void move() {
		switch(handler.getEntityManager().getPlayer().getFacing()) {
		case "Up":
			this.handler.setYInWorldDisplacement(this.handler.getYInWorldDisplacement()-150);
			break;
		case "Right":
			this.handler.setYInWorldDisplacement(this.handler.getYInWorldDisplacement()-150);
			break;
		case "Left":
			this.handler.setYInWorldDisplacement(this.handler.getYInWorldDisplacement()-150);
			break;
		}
	}
	
	private void checkQuest() {
		if(completedQuest) {
			if(index2==0) {
				handler.getEntityManager().getPlayer().setSkill("IceSkill");
				System.out.println("Player gained "+handler.getEntityManager().getPlayer().getSkill());
				index2=1;
			}
		}
			
	}
	
	@Override
	public Rectangle getCollision() {
		return collision;
	}
	
	public boolean inArea() {
		return handler.getEntityManager().getPlayer().getCollision().intersects(getCollision());
	}
	
	@Override
	public double getXOffset() {
		return xPosition;
	}
	
}
