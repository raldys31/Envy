package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Main.GameSetUp;
import Main.Handler;
import Resources.Images;

public class Bowser extends BaseStaticEntity {
	
	Rectangle collision;
	int width, height;
	private int count=0;
	private int index=0;
	
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
		if(inArea() && count==3) {
			count=0;
					if(handler.getEntityManager().getPlayer().getSkill().equals("none")) {
						this.handler.showMessage("Need a skill brooo!", "Need Skill", Images.bowserIcon);
						switch(handler.getEntityManager().getPlayer().getFacing()) {
						case "Up":
							this.handler.setYDisplacement(this.handler.getYDisplacement()-150);
							break;
						case "Right":
							this.handler.setXDisplacement(this.handler.getXDisplacement()+150);
							break;
						case "Left":
							this.handler.setXDisplacement(this.handler.getXDisplacement()-150);
							break;
						}
					}
					else if(index==0){ 
						index=1;
						this.setXOffset(1638+80);
						this.handler.showMessage("CONGRATS!!", "Got a Skill, you may pass", Images.bowserIcon);
						
					}
		}
		else if(inArea()&&count<3){
			count++;
		}
		
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
