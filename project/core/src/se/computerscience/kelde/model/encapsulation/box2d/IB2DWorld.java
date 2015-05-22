/**
 * Description: Separates model from framework. Box2dWorld.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.physics.box2d.World;

public interface IB2DWorld {
    World getBox2DWorld();
    void step(float timeStep, int velocityIterations, int positionIterations);
    void dispose();
}
