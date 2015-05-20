package se.computerscience.kelde.model.entities;

import org.junit.Assert;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.libgdx.Camera;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.physics.WorldPhysics;

import static org.junit.Assert.*;

/**
 * Created by Anders on 2015-05-20.
 */
public class EntityBatTest {


    @Test
    public void testGetHealth() throws Exception {
        String MAP_LOCATION = "map.tmx";
        WorldPhysics worldPhysics;
        IMap map;
        map = new Map(MAP_LOCATION);
        worldPhysics = new WorldPhysics(map);

        EntityBat bat = new EntityBat(100,100, worldPhysics.getIb2DWorld());
        Assert.assertEquals(100, bat.getHealth());
    }
}