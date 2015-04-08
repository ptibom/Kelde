/* Description: Renders a tile-map with camera.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import net.dermetfan.gdx.physics.box2d.Box2DMapObjectParser;
import se.computerscience.kelde.controller.gameworld.GameWorldController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.gameworld.GameWorldView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;


public class GameScreen implements Screen {
    private OrthographicCamera box2dCamera; // Camera is the view from where the scene is rendered.

    private GameWorld gameWorld;
    private GameWorldController gameWorldController;
    private GameWorldView gameWorldView;

    private WorldPhysics worldPhysics;
    private WorldPhysicsView worldPhysicsView;
    private WorldPhysicsController worldPhysicsController;

    private Body body;
    private Texture texture;
    private SpriteBatch batch;
    private final float BOX2D_SCALE = 0.01f; // Exists in WorldPhysics, this is temporary for testing

    @Override
    public void show() {
        // Initialises objects, like a constructor

        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView();
        gameWorldController = new GameWorldController(gameWorld, gameWorldView);

        worldPhysics = new WorldPhysics(gameWorld);
        worldPhysicsView = new WorldPhysicsView(worldPhysics);
        worldPhysicsController = new WorldPhysicsController(worldPhysics, worldPhysicsView);

        loadTestPlayer();
    }
    @Override
    public void render(float delta) {
        // Renders the scene, first clear it with black.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render the world
        gameWorldController.render(delta);

        // Update physics & render debugging
        worldPhysicsController.update(delta);
        worldPhysicsController.renderDebug(delta); // Comment this line to remove debugging.

        renderTestPlayer();
    }

    @Override
    public void resize(int width, int height) {
        gameWorldController.resizeCamera(width, height);
        worldPhysicsController.resizeCamera(width, height);
        batch.setProjectionMatrix(gameWorld.getCamera().combined);
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
        gameWorldController.dispose();
        worldPhysics.dispose();
    }

    public void loadTestPlayer() {
        // Temporary test Player to test Collisions
        BodyDef def = new BodyDef();
        def.position.set(70*BOX2D_SCALE, 50*BOX2D_SCALE);
        def.type = BodyType.DynamicBody;
        body = worldPhysics.getBox2dWorld().createBody(def);
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(16*BOX2D_SCALE, 8*BOX2D_SCALE);
        fdef.shape = shape;
        body.createFixture(fdef);

        texture = new Texture("testSprite.png");
        batch = new SpriteBatch();
        // End of temporary player
    }

    public void renderTestPlayer() {
        // Testing temporary player for collisions
        int x = 0, y = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y = 2;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y = -2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x = 2;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x = -2;
        }
        body.setLinearVelocity(x, y);

        Sprite player = new Sprite(texture, 32, 48);
        player.setPosition(body.getPosition().x/BOX2D_SCALE - 16, body.getPosition().y/BOX2D_SCALE - 6);

        batch.begin();
        player.draw(batch);
        batch.end();
        // End of temporary player
    }
}
