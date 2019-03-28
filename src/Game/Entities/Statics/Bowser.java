package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Game.World.InWorldAreas.TownArea;
import Main.GameSetUp;
import Main.Handler;
import Resources.Images;

public class Bowser extends BaseStaticEntity {
	
	Rectangle collision;
	int width, height;
	private int index=0;
	private int index2;
	
	public Bowser(Handler handler, int xPosition, int yPosition) {
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

		g.drawImage(Images.bowser, (int)(handler.getXDisplacement() + xPosition),
				(int)( handler.getYDisplacement() + yPosition), width, height, null);
		collision = new Rectangle((int)(handler.getXDisplacement() + xPosition),
				(int)( handler.getYDisplacement() + yPosition), width, height);
		if (GameSetUp.DEBUGMODE) {
			g2.draw(getCollision());
		}
		checkCollisions();

	}
	
	private void checkCollisions() {
		if(inArea()) {
			
			if(index2==0) {
					if(handler.getEntityManager().getPlayer().getSkill().equals("none")) {
						this.handler.showMessage("Need a skill brooo!", "Need Skill", Images.bowserIcon);
						index2=1;
						handler.setYDisplacement(handler.getYDisplacement() - 75);
					}
					else if(index==0){
						this.setXOffset(1638+80);
						this.handler.showMessage("CONGRATS!!", "Got a Skill", Images.bowserIcon);
						index = 1;
					}
			}
			
		}
		else index2=0;
	}

	private boolean inArea() {
		return handler.getEntityManager().getPlayer().getCollision().intersects(getCollision());
	}
	
	@Override
	public Rectangle getCollision() {
		return collision;
	}
	
	@Override
	public double getXOffset() {
		return xPosition;
	}
	
	
}
