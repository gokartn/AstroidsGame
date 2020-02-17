/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.playersystem.Player;

/**
 *
 * @author Morten
 */
public class CollisionControlSystem implements IEntityProcessingService{
    private PositionPart positionPart;

    @Override
    public void process(GameData gameData, World world) {
        float playerXPos = 0;
        float playerYpos = 0;
        float asteroidXPos;
        float asteroidYPos;
        for (Entity player : world.getEntities(Player.class)){
            PositionPart positionPart = player.getPart(PositionPart.class);
            if (!(positionPart == null)) {
            playerXPos = positionPart.getX();
            playerYpos = positionPart.getY();
            System.out.println("Player x = " + playerXPos + " y = " + playerYpos);
            }
            
            for(Entity asteroid : world.getEntities(Asteroid.class)) {
                PositionPart positionPart1 = asteroid.getPart(PositionPart.class);
                asteroidXPos = positionPart1.getX();
                asteroidYPos = positionPart1.getY();
                System.out.println("asteroid x = " + asteroidXPos + " y = " + asteroidYPos);
                
            }
            
        }
       
    }
    
}
