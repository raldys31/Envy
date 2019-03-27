package Game.World.InWorldAreas;

import Main.GameSetUp;
import Main.Handler;
import Resources.Images;
import java.awt.*;
import java.util.ArrayList;

import Game.Entities.EntityManager;
import Game.Entities.Statics.Bowser;
import Game.Entities.Statics.LightStatue;
import Game.Entities.Statics.Toad;
import Game.Entities.Statics.Tree;
import Game.World.Walls;

public class TownArea extends BaseArea {

    Rectangle exit;
    Rectangle playerRect;
    public static boolean isInTown = false;

    private int imageWidth = 4960, imageHeight = 3840;
    public static final int playerXSpawn = -200;
    		;
	public static final int playerYSpawn = -3300;

    private Rectangle background = new Rectangle(3000, 3000);

    public static ArrayList<InWorldWalls> townWalls;

    
    public TownArea(Handler handler, EntityManager entityManager) {
        super(handler, entityManager);
        name="Town";
        handler.setXInWorldDisplacement(playerXSpawn);
        handler.setYInWorldDisplacement(playerYSpawn);

        playerRect = new Rectangle((int) handler.getWidth() / 2 - 5, (int) (handler.getHeight() / 2) + 300, 70, 70);

        this.entityManager = entityManager;

        this.entityManager.AddEntity(handler.newEnemy(Images.PEnemyIdle,handler,5097, 1370,"InWorldState","Pikachu","Town","EnemyOne",150,25,80,1,8,12,20,10,20,10,1,10,"None","Thunder",null,null)); //lvl 2 difficulty
        this.entityManager.AddEntity(handler.newEnemy(Images.CEnemyIdle,handler,4153, 1366,"InWorldState","Charizard","Town","Charizard",100,25,60,10,1,12,20,10,20,13,1,10,"None","Thunder",null,null)); // lvl 1 difficulty
        this.entityManager.AddEntity(handler.newEnemy(Images.SEnemyIdle,handler,981, 3238,"InWorldState","Scyther","Town","Scyther",150,25,80,1,8,12,20,10,20,10,1,10,"None","Thunder",null,null)); //lvl 2 difficulty
        this.entityManager.AddEntity(handler.newEnemy(Images.MEnemyIdle,handler,5181, 1974,"InWorldState","Mewtwo","Town","Mewtwo",150,25,80,1,8,12,20,10,20,10,1,10,"None","Thunder",null,null)); //lvl 2 difficulty
        
      //statics entities
        this.entityManager.AddEntity(new Toad(handler, 2885, 1350));
        
        townWalls = new ArrayList<>();
        AddWalls();

    }

    public void tick() {
        super.tick();

        for (Walls w : townWalls) {
            w.tick();
        }
        if(!GameSetUp.LOADING) {
            entityManager.tick();
        }

    }

    @Override
    public void render(Graphics g) {
        super.render(g);


        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.black);
        g2.fill(background);

        g.drawImage(Images.ScaledTown, handler.getXInWorldDisplacement(), handler.getYInWorldDisplacement(), null);

        if (GameSetUp.DEBUGMODE) {
            for (Walls w : townWalls) {

                if (w.getType().equals("Wall"))
                    g2.setColor(Color.black);
                else
                    g2.setColor(Color.PINK);

                w.render(g2);
            }
        }


        entityManager.render(g2);

    }

    private void AddWalls() {
    				//X,Y,WIDTH,HEIGHT
    	//First House Area
        townWalls.add(new InWorldWalls(handler, 757, 2970, 25, 1009, "Wall"));								
        townWalls.add(new InWorldWalls(handler, 723, 3090, 961, 61, "Wall"));					
        townWalls.add(new InWorldWalls(handler, 1609, 2946, 65, 361, "Wall"));	
        townWalls.add(new InWorldWalls(handler,1237, 3356, 99, 83, "Wall"));								
        townWalls.add(new InWorldWalls(handler, 963, 3432, 391, 371, "Wall"));					
        townWalls.add(new InWorldWalls(handler, 1445, 3750, 69, 133, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1359, 3710, 329, 85, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1619, 3450, 45, 351, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1213, 3138, 141, 91, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1127, 3336, 105, 9, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1101, 3348, 35, 69, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1057, 3372, 33, 37, "Wall"));
        townWalls.add(new InWorldWalls(handler, 983, 3410, 63, 13, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1283, 4022, 641, 87, "Wall"));
        townWalls.add(new InWorldWalls(handler, 729, 4068, 553, 39, "Wall"));
        townWalls.add(new InWorldWalls(handler, 729, 3984, 197, 79, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1337, 2669, 365, 17, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1373, 2947, 301, 19, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1285, 2785, 141, 161, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1333, 2675, 19, 105, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1699, 2647, 127, 95, "Wall"));
        
        //Bridges and Water Areas
        townWalls.add(new InWorldWalls(handler, 2025, 3664, 19, 413, "Wall"));
        townWalls.add(new InWorldWalls(handler, 1923, 4074, 129, 13, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2029, 3664, 171, 15, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2185, 3576, 27, 103, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2215, 3564, 337, 125, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2021, 3100, 543, 221, "Wall"));
        townWalls.add(new InWorldWalls(handler, 2179, 2966, 383, 125, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2221, 2932, 295, 33, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2562, 3020, 235, 209, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2556, 3566, 189, 39, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2662, 3422, 515, 199, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3036, 2812, 635, 459, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3154, 3270, 21, 145, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2657, 2642, 141, 103, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 1829, 2672, 827, 15, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3031, 2650, 21, 157, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3001, 2548, 25, 151, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3029, 2356, 27, 189, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2975, 2302, 57, 127, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2243, 2256, 471, 373, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2715, 2528, 51, 109, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2483, 2010, 13, 239, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2501, 1902, 185, 149, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2971, 1906, 131, 391, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3061, 1774, 43, 127, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2913, 1906, 59, 145, "Wall"));	
        
        //Top Houses Area
        townWalls.add(new InWorldWalls(handler, 2497, 1402, 57, 497, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 2559, 1006, 235, 539, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3045, 1296, 151, 95, "Wall"));
        townWalls.add(new InWorldWalls(handler, 2795, 1308, 249, 23, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3067, 1394, 35, 237, "Wall"));
        townWalls.add(new InWorldWalls(handler, 3531, 1512, 481, 189, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3199, 1348, 373, 31, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3531, 1376, 19, 131, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3080, 2234, 515, 21, "Wall"));
        townWalls.add(new InWorldWalls(handler, 3942, 1928, 323, 151, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 4240, 1498, 17, 435, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3942, 2070, 13, 339, "Wall"));
        townWalls.add(new InWorldWalls(handler, 3584, 2230, 9, 187, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3586, 2383, 65, 163, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3878, 2391, 119, 139, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3764, 1061, 15, 451, "Wall"));
        townWalls.add(new InWorldWalls(handler, 3780, 1199, 133, 121, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 4410, 1119, 875, 111, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3782, 1137, 633, 19, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 4260, 1501, 701, 33, "Wall"));	
        
        //Right Corner Houses
        townWalls.add(new InWorldWalls(handler, 5285, 1143, 323, 897, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 5513, 2023, 15, 283, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 5289, 2287, 475, 297, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 4937, 1499, 21, 409, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 4957, 1865, 71, 733, "Wall"));
        townWalls.add(new InWorldWalls(handler, 3995, 2523, 1033, 75, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3575, 2530, 29, 281, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 3671, 2994, 489, 17, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 4025, 2874, 619, 217, "Wall"));
        townWalls.add(new InWorldWalls(handler, 4645, 2733, 1513, 167, "Wall"));
        townWalls.add(new InWorldWalls(handler, 5765, 2469, 393, 17, "Wall"));	
        townWalls.add(new InWorldWalls(handler, 5875, 2517, 99, 45, "Wall"));	
        
        //Exit
        townWalls.add(new InWorldWalls(handler, 6061, 2568, 89, 119, "Start Exit"));

    }

    @Override
    public ArrayList<InWorldWalls> getWalls() {
        return townWalls;
    }
}
