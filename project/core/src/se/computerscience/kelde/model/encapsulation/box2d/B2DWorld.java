/**
 * Description: Box2DWorld wrapper.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class B2DWorld implements IB2DWorld {
    private final World box2dWorld;

    public B2DWorld() {
        box2dWorld = new World(new Vector2(0, 0), true);
    }

    @Override
    public World getBox2DWorld() {
        return box2dWorld;
    }

    @Override
    public void step(float timeStep, int velocityIterations, int positionIterations) {
        box2dWorld.step(timeStep, velocityIterations, positionIterations);
    }

    @Override
    public void dispose() {
        box2dWorld.dispose();
    }
}
