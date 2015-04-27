/**
 * Description: Separates framework from model.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.encapsulation;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;

public interface ICamera {
    public OrthographicCamera getOrthographicCamera();
    public void setViewPortHeight(float height);
    public void setViewPortWidth(float width);
    public void setPosition(float x, float y, float z);
    public void update();
}
