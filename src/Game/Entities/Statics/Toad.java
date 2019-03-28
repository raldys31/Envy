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
		}
		
	}
	
	private void checkCollision() {
		int selected;
		if(inArea()) {
			if(index2==0) {
				if(handler.getEntityManager().getPlayer().getSkill().equals("none")) {
					selected = this.handler.showOptionMessage("Want a skill boi?", "Quest", Images.toadIcon);
					index2=1;
					if(selected == 0) {
						this.handler.showMessage("Defeat en enemy on this town", "Quest", Images.toadIcon);
					}
					handler.setYInWorldDisplacement(handler.getYInWorldDisplacement()-150);
				}
				else if(handler.getEntityManager().getPlayer().getSkill().equals("IceSkill")) {
					selected = this.handler.showOptionMessage("Want a different skill boi?", "Quest", Images.toadIcon);
					index2=1;
					if(selected == 0) {
						this.handler.showMessage("Defeat en enemy on this town to gain FireSkill", "Quest", Images.toadIcon);
					}
					handler.setYInWorldDisplacement(handler.getYInWorldDisplacement()-150);
				}
				else if(index==0) {
					this.handler.showMessage("Defeated an enemy!", "CONGRATS!!", Images.toadIcon);
					handler.setYInWorldDisplacement(handler.getYInWorldDisplacement()-150);
					index=1;
				}
			}
		}
		else index2=0; index=0;
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
