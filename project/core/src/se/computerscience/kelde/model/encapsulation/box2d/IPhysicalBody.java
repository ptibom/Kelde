/**
 * Description: Separates model from framework. Physical bodies.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;


public interface IPhysicalBody {
    public void destroy();
    public void setVelocity(float x, float y);
    public float getPositionY();
    public float getPositionX();
    public Body getBody();
    public FixtureDef getFdef();
    public float getVelocityX();
    public float getVelocityY();
    public void setDampening(float dampening);
    public void setPosition(float x, float y);
}
