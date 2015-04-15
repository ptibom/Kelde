/* Description: Renders a tile-map with camera.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.controller.ControlBat;
import se.computerscience.kelde.controller.entities.EyeController;
import se.computerscience.kelde.model.EntityBat;

public class MapScreen implements Screen {
    private OrthographicCamera camera; // Camera is the view from where the scene is rendered.
    private OrthogonalTiledMapRenderer renderer; // Renders the map
    private TiledMap map; // Loads the map

    private ControlBat bat1;
    private EyeController eye1;

    @Override
    public void show() {
        // Initialises objects, like a constructor
        map = new TmxMapLoader().load("map.tmx");
        camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(map);
        EntityBat ebat = new EntityBat();
        ViewBat vbat = new ViewBat();
        bat1 = new ControlBat(ebat, vbat);
        eye1 = new EyeController();
    }

    @Override
    public void render(float delta) {
        // Renders the scene, first clear it with black.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Choose to render from Camera's perspective and then render it.
        renderer.setView(camera);
        renderer.render();
        bat1.render();
        eye1.render(camera);


    }

    @Override
    public void resize(int width, int height) {

        if (height%2 == 1) {
            height--; // Keeps viewport "even" and prevents texture-distortion.
        }
        if (width%2 == 1) {
            width--; // Keeps viewport "even" and prevents texture-distortion.
        }
        // Prevents stretching/resizing of images. Keeps a perfect resolution when window is resized.
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.position.set(width / 2, height / 2, 0); // Temporary camera position. Divide by 2 to make the map stick by the corner.
        camera.update();
        bat1.resize(camera);
    }

    @Override
    public void pause() {
        //TODO: Pause
    }

    @Override
    public void resume() {
        //TODO: Resume
    }

    @Override
    public void hide() {
        // When screen is no longer used, dispose the objects.
        dispose();
    }

    @Override
    public void dispose() {
        // Frees up memory
        map.dispose();
        renderer.dispose();
    }
}
