package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Rectangle;

import Game.World.InWorldAreas.TownArea;
import Main.Handler;
import Resources.Images;

public class Bowser extends BaseStaticEntity {
	
	Rectangle collision;
	int width, height;
	
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
		if(TownArea.isInTown) {
			g.drawImage(Images.bowser, (int)(handler.getXInWorldDisplacement() + xPosition),
					(int)( handler.getYInWorldDisplacement() + yPosition), width, height, null);
			collision = new Rectangle((int)(handler.getXInWorldDisplacement()),
					(int)( handler.getYInWorldDisplacement() + yPosition), width+30, height);
		}
		else {
			g.drawImage(Images.bowser, (int)(handler.getXDisplacement() + xPosition),
					(int)( handler.getYDisplacement() + yPosition), width, height, null);
			collision = new Rectangle((int)(handler.getXDisplacement() + xPosition),
					(int)( handler.getYDisplacement() + yPosition), width, height);
		}
		
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
