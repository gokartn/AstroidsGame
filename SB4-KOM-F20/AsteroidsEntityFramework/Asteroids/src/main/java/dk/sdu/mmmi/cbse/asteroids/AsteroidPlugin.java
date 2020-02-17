/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroids;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;

/**
 *
 * @author Morten
 */
public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;
    private Entity asteroid2;
    private Entity asteroid3;
    private Entity asteroid4;

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        int amountOfAst = 0;
        while(amountOfAst < 5) {
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
           amountOfAst++;
        }
        
    }

    private Entity createAsteroid(GameData gameData) {
        Random rand = new Random(100);
        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 150;
        float rotationSpeed = 2;
        float x = rand.nextFloat();
        float y = rand.nextFloat();
        float radians = 3.1415f / 2;

        
        Entity asteroid = new Asteroid();
        asteroid.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        System.out.println("Asteroid X = " + x + " Asteroid Y = " + y);
        asteroid.add(new PositionPart(x, y, radians));
        
        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(asteroid);
    }

}
