/**
 * Description: Encapsulates OrthographicCamera from Model.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.encapsulation;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;

public class Camera implements ICamera {
    OrthographicCamera orthographicCamera;

    public Camera() {
        this.orthographicCamera = new OrthographicCamera();
    }

    @Override
    public OrthographicCamera getOrthographicCamera() {
        return orthographicCamera;
    }

    @Override
    public void setViewPortHeight(float height) {
        orthographicCamera.viewportWidth = height;
    }

    @Override
    public void setViewPortWidth(float width) {
        orthographicCamera.viewportWidth = width;
    }

    @Override
    public void setPosition(float x, float y, float z) {
        orthographicCamera.position.set(x, y, z);
    }

    @Override
    public void update() {
        orthographicCamera.update();
    }
}
