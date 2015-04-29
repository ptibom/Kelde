/**
 * Description: Separates model from framework. Box2dWorld.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.encapsulation.box2d;

import com.badlogic.gdx.physics.box2d.World;

public interface IB2DWorld {
    public World getBox2DWorld();
    public void step(float timeStep, int velocityIterations, int positionIterations);
    public void dispose();
}
