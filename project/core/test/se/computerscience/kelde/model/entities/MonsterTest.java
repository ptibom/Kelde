package se.computerscience.kelde.model.entities;

import org.junit.Assert;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.physics.WorldPhysics;

/**
 * Created by Anders on 2015-05-19.
 * @author Anders Bolin
 */
public class MonsterTest {

    @Test
    public void testEntityBat() {
        Map map = new Map("core/assets/map.tmx");
        WorldPhysics worldPhysics = new WorldPhysics(map);
        EntityBat bat = new EntityBat(100,100,worldPhysics.getIb2DWorld());

        Assert.assertEquals(100, bat.getHealth());
        //Assert.assertEquals(true, entityShop.isFriendly());
    }
}
