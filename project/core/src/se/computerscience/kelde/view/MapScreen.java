/* Description: Renders a tile-map with camera.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import net.dermetfan.gdx.physics.box2d.Box2DMapObjectParser;


public class MapScreen implements Screen {
    private OrthographicCamera camera; // Camera is the view from where the scene is rendered.
    private OrthogonalTiledMapRenderer renderer; // Renders the map
    private TiledMap map; // Loads the map
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;
    private Body body;
    private Texture texture;
    private SpriteBatch batch;

    @Override
    public void show() {
        // Initialises objects, like a constructor
        map = new TmxMapLoader().load("map.tmx");
        camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(map);
        world = new World(new Vector2(0, 0), true);
        box2DDebugRenderer = new Box2DDebugRenderer();
        Box2DMapObjectParser parser = new Box2DMapObjectParser();
        parser.load(world, map.getLayers().get("Collision"));


        // Create a player
        BodyDef def = new BodyDef();
        def.position.set(70, 50);
        def.type = BodyType.DynamicBody;
        body = world.createBody(def);
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(16, 24);
        fdef.shape = shape;
        body.createFixture(fdef);

        texture = new Texture("testSprite.png");
        batch = new SpriteBatch();
    }
    @Override
    public void render(float delta) {
        // Renders the scene, first clear it with black.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        int x = 0, y = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y = 100;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y = -100;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x = 100;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x = -100;
        }
        body.setLinearVelocity(x, y);
        world.step(delta, 6, 2);
        // Choose to render from Camera's perspective and then render it.
        renderer.setView(camera);
        renderer.render();

        Sprite player = new Sprite(texture, 32, 48);
        player.setPosition(body.getPosition().x - 16, body.getPosition().y - 24);

        batch.begin();
        player.draw(batch);
        batch.end();

        box2DDebugRenderer.render(world, camera.combined);
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

        batch.setProjectionMatrix(camera.combined);
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
