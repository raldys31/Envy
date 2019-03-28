package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Main.GameSetUp;
import Main.Handler;
import Resources.Images;

public class Toad extends BaseStaticEntity {
	
	Rectangle collision, inArea;
	int width, height;
	private int index;
	
	public Toad(Handler handler, int xPosition, int yPosition) {
		super(handler, xPosition, yPosition);
		width = 100;
		height = 100;
		
		this.setXOffset(xPosition);
		this.setYOffset(yPosition);
		
		collision = new Rectangle();
		inArea = new Rectangle();
	}
	
	
	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(Images.toad, (int)(handler.getXInWorldDisplacement() + xPosition),
				(int)( handler.getYInWorldDisplacement() + yPosition), width, height, null);
		collision = new Rectangle((int)(handler.getXInWorldDisplacement() + xPosition), 
				(int)(handler.getYInWorldDisplacement() + yPosition), width/2, height/2);
		inArea = new Rectangle((int)(handler.getXInWorldDisplacement() + xPosition - 20), 
				(int)(handler.getYInWorldDisplacement() + yPosition), width+70, height+200);
		if (GameSetUp.DEBUGMODE) {
			g2.draw(getCollision());
			g2.draw(inArea);
		}
		checkCollision();
	}
	
	private void checkCollision() {
		int selected;
		if(inArea()) {
			if(index==0) {
				if(handler.getEntityManager().getPlayer().getSkill().equals("none")) {
					selected = this.handler.showOptionMessage("Want a skill boi?", Images.toadIcon);
					index=1;
					if(selected == 0) {
						this.handler.showMessage("Defeat en enemy on this town", "Quest", Images.toadIcon);
						handler.getEntityManager().getPlayer().setYOffset(handler.getYInWorldDisplacement() + yPosition+300);
					}
				}
				else if(!handler.getEntityManager().getPlayer().getSkill().equals("none")) {
					this.handler.showMessage("Defeated an enemy!", "CONGRATS!!", Images.toadIcon);
					handler.getEntityManager().getPlayer().setYOffset(handler.getYInWorldDisplacement() + yPosition + 300);
					index=0;
				}
					
				}
			}
		}
	
	@Override
	public Rectangle getCollision() {
		return collision;
	}
	
	public boolean inArea() {
		return handler.getEntityManager().getPlayer().getCollision().intersects(inArea);
	}
	
	@Override
	public double getXOffset() {
		return xPosition;
	}
	
}
