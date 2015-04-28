/** Description: Renders a tile-map with camera.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import se.computerscience.kelde.controller.gameworld.GameWorldController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.gameworld.GameWorldView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;


public class GameScreen implements Screen {
    private GameWorld gameWorld;
    private GameWorldController gameWorldController;
    private GameWorldView gameWorldView;

    private Body body;
    private Texture texture;
    private SpriteBatch batch;
    private static final float BOX2D_SCALE = 0.01f; // Exists in WorldPhysics, this is temporary for testing

    @Override
    public void show() {
        // Initialises objects, like a constructor
        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView(gameWorld);
        gameWorldController = new GameWorldController(gameWorld, gameWorldView);

        loadTestPlayer();
    }
    @Override
    public void render(float delta) {
        // Renders the scene, first clear it with black.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render the world
        gameWorldController.render(delta);

        renderTestPlayer();
    }

    @Override
    public void resize(int width, int height) {
        gameWorldController.resizeCamera(width, height);
        batch.setProjectionMatrix(gameWorld.getCamera().getOrthographicCamera().combined);
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
    }

    public void loadTestPlayer() {
        // Temporary test Player to test Collisions
        BodyDef def = new BodyDef();
        def.position.set(70*BOX2D_SCALE, 50*BOX2D_SCALE);
        def.type = BodyType.DynamicBody;
        body = gameWorld.getWorldPhysics().getBox2dWorld().createBody(def);
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
