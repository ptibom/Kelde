/**
 * Description: Separates framework from model.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.OrthographicCamera;

public interface ICamera {
    OrthographicCamera getOrthographicCamera();
    void setViewPortHeight(float height);
    void setViewPortWidth(float width);
    void setPosition(float x, float y, float z);
    void update();
}
