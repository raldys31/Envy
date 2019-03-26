package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Rectangle;
import Main.Handler;
import Resources.Images;

public class Toad extends BaseStaticEntity {
	
	Rectangle collision;
	int width, height;
	
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
		g.drawImage(Images.toad, (int)(handler.getXInWorldDisplacement() + xPosition),(int)( handler.getYInWorldDisplacement() + yPosition), width, height, null);
		collision = new Rectangle((int)(handler.getXInWorldDisplacement() + xPosition + 35), (int)(handler.getYInWorldDisplacement() + yPosition + 50), width/2, height/2);
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
