package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Rectangle;
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
		g.drawImage(Images.bowser, (int)(handler.getXDisplacement() + xPosition),(int)( handler.getYDisplacement() + yPosition), width, height, null);
		collision = new Rectangle((int)(handler.getXDisplacement() + xPosition),(int)( handler.getYDisplacement() + yPosition), width, height);
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
