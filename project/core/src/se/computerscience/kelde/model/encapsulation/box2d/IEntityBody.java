/**
 * Description: Separates model from framework. Physical bodies.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

public interface IEntityBody {
    public void destroy();
    public void setVelocity(float x, float y);
    public float getPositionY();
    public float getPositionX();
}
