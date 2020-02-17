/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

/**
 *
 * @author Morten
 */
public class CollisionPlugin implements IGamePluginService {
    private Entity collision;

    @Override
    public void start(GameData gameData, World world) {
       collision = new Collision();
       world.addEntity(collision);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(collision);
    }
    
}
