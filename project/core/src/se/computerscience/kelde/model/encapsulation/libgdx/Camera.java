/**
 * Description: Encapsulates OrthographicCamera from Model.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera implements ICamera {
    OrthographicCamera orthographicCamera;

    public Camera() {
        orthographicCamera = new OrthographicCamera();
    }

    public Camera(float width, float height) {
        orthographicCamera = new OrthographicCamera(width, height);
    }

    @Override
    public OrthographicCamera getOrthographicCamera() {
        return orthographicCamera;
    }

    @Override
    public void setViewPortHeight(float height) {
        orthographicCamera.viewportHeight = height;
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
