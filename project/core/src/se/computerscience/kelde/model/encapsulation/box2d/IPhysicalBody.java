/**
 * Description: Separates model from framework. Physical bodies.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;


public interface IPhysicalBody {
<<<<<<< HEAD
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
=======
    void destroy();
    void setVelocity(float x, float y);
    float getPositionY();
    float getPositionX();
    Body getBody();
    FixtureDef getFdef();
    float getVelocityX();
    float getVelocityY();
    void setDampening(float dampening);
    void setPosition(float x, float y);
>>>>>>> master
}
