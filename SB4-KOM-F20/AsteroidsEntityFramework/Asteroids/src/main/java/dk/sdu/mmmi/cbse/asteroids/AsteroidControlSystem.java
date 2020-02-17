/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroids;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.LEFT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.RIGHT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.UP;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Random;
import javax.swing.text.Position;

/**
 *
 * @author Morten
 */
public class AsteroidControlSystem implements IEntityProcessingService{
    private MovingPart movingPart;
    private PositionPart positionPart;
    private int moveing = 0;
    
    @Override
    public void process(GameData gameData, World world) {
    for (Entity asteroid : world.getEntities(Asteroid.class)) {
            positionPart = asteroid.getPart(PositionPart.class);
            movingPart = asteroid.getPart(MovingPart.class);
           
            Random rand = new Random();
            moveing = rand.nextInt(100);
            moveAstroid();
//          movingPart.setLeft(gameData.getKeys().isDown(LEFT));
//          movingPart.setRight(gameData.getKeys().isDown(RIGHT));
//          movingPart.setUp(gameData.getKeys().isDown(UP));
            
            
            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);

            updateShape(asteroid);
        }
    }
    
  private void updateShape(Entity entity) {
      PositionPart positionPart = entity.getPart(PositionPart.class);
        float[] shapex = new float[8];
        float[] shapey = new float[8];
        float[] dists = new float[8];
        float radians = positionPart.getRadians();
        float x = positionPart.getX();
        float y = positionPart.getY();

        int radius = 40 / 2;
        for (int i = 0; i < 8; i++) {
            dists[i] = (radius / 2);
        }
        float angle = 0;
		for(int i = 0; i < 8; i++) {
			shapex[i] = (float) (x + Math.cos(angle + radians) * dists[i]);
			shapey[i] = (float) (y + Math.sin(angle + radians) * dists[i]);
			angle += 2 * 3.1415f / 11;
		}

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }  
    
  private void moveAstroid(){
      if(moveing < 20){
          movingPart.setRight(true);
      }else if (moveing > 50) {
          movingPart.setLeft(true);
      }
      
      movingPart.setUp(true);
  }
}
