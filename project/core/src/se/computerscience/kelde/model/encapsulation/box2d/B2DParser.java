/**
 * Description: Wrapping Box2d map object parser
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import net.dermetfan.gdx.physics.box2d.Box2DMapObjectParser;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;

public class B2DParser implements IB2DParser {
    private final Box2DMapObjectParser parser;
    public B2DParser(float scale) {
        // Load all the objects from the Game Map and populate the box2d world with polygon objects.
        parser = new Box2DMapObjectParser(scale);
    }

    @Override
    public void load(IB2DWorld world, IMap map) {
        parser.load(world.getBox2DWorld(), map.getTiledMap()); // Objects loaded to box2d.
    }
}
