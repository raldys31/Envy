package Game.Entities;

import java.awt.Graphics;
import java.util.ArrayList;

import Game.Entities.Dynamics.BaseHostileEntity;
import Game.Entities.Dynamics.Player;
import Game.Entities.Statics.BaseStaticEntity;
import Main.GameSetUp;
import Main.Handler;

public class EntityManager {
	
	protected Handler handler;
	protected Player player;
	
	ArrayList<BaseEntity> entities;
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		
		entities = new ArrayList<>();
	}
	
	public void tick() {
		
		for (BaseEntity e : entities) {
			if(e instanceof  BaseHostileEntity){
				if(!((BaseHostileEntity) e).isDead()) {
					if(((BaseHostileEntity) e).Area.equals(handler.getArea())){
						CheckCollisions(e);
						e.tick();
					}
				}
			}else {
				CheckCollisions(e);
				e.tick();
			}
		}
		
		player.tick();
		
	}
	
	
	private void CheckCollisions(BaseEntity e) {
		
		if ( player.getCollision().intersects(e.getCollision())&&!GameSetUp.SWITCHING) {
			
			if (e instanceof BaseStaticEntity){
				player.WallBoundary(e.getXOffset());
			}

		}
		
		
		
		// Make it so it checks if ALL Dynamic entities INTERSECTED with ALL STATIC entities ?
		
	}

	public void render(Graphics g){
		
		player.render(g);
		
		for (BaseEntity e : entities) {
			if(e instanceof BaseHostileEntity) {
				if(!((BaseHostileEntity) e).isDead()) e.render(g);
			}
			else {
				e.render(g);
			}
		}

	}
	
	
	public void AddEntity(BaseEntity e) {
		entities.add(e);
	}


	public void RemoveEntity(BaseEntity e) {
		entities.remove(e);
	}
	
	public ArrayList<BaseEntity> getEntities(){
		return this.entities;
	}

	public Player getPlayer() {
		return player;
	}
}
