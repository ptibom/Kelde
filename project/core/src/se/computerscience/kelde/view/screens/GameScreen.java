/** Description: Renders a tile-map with camera.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.uwsoft.editor.renderer.actor.SpriteAnimation;
import net.dermetfan.gdx.graphics.g2d.AnimatedBox2DSprite;
import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;
import se.computerscience.kelde.controller.entities.ControlBat;
import se.computerscience.kelde.controller.entities.EyeController;
import se.computerscience.kelde.controller.entities.SmallWormController;
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

    private WorldPhysics worldPhysics;
    private WorldPhysicsView worldPhysicsView;
    private WorldPhysicsController worldPhysicsController;

    private Body body,bodybat;
    private Texture texture;
    private SpriteBatch batch;
    private static final float BOX2D_SCALE = 0.01f; // Exists in WorldPhysics, this is temporary for testing

    private float ELAPSED_TIME = 0;
    private float ELAPSED_TIME1 = 0;
    private TextureAtlas keldeWalkNorth, keldeWalkWest, keldeWalkSouth, keldeWalkEast, keldeLookNorth, keldeLookEast, keldeLookSouth, keldeLookWest;
    private Animation animation, animationWalkNorth, animationWalkWest, animationWalkSouth, animationWalkEast, STANDING_STILL_NORTH, STANDING_STILL_WEST, STANDING_STILL_EAST, STANDING_STILL_SOUTH;
    private TextureAtlas keldeNorthKnife, keldeEastKnife, keldeSouthKnife, keldeWestKnife;
    private Animation knifeslashnorth, knifeslasheast,knifeslashwest,knifeslashsouth;

    private ControlBat bat1;
    private EyeController eye1;
    private SmallWormController worm1;

    public enum HEADING {
        NORTH, SOUTH, WEST, EAST
    }
    private HEADING direction;

    @Override
    public void show() {
        // Initialises objects, like a constructor
        direction = HEADING.NORTH;
        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView();
        gameWorldController = new GameWorldController(gameWorld, gameWorldView);

        worldPhysics = new WorldPhysics(gameWorld);
        worldPhysicsView = new WorldPhysicsView(worldPhysics);
        worldPhysicsController = new WorldPhysicsController(worldPhysics, worldPhysicsView);

        bat1 = new ControlBat(new Vector2(300,300));
        eye1 = new EyeController(new Vector2(200,200));
        worm1 = new SmallWormController(new Vector2(300,300));

        loadTestPlayer();
        loadBat();
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
        //worldPhysicsController.renderDebug(delta); // Comment this line to remove debugging.

        worm1.render(gameWorld.getCamera());
        renderTestPlayer();
        eye1.render(gameWorld.getCamera());


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

        createNorthTexture();
        createWestTexture();
        createSouthTexture();
        createEastTexture();
        createKeldeStanding();
        createKnifeSlash();
        // End of temporary player
    }

    private void createKnifeSlash() {
        keldeNorthKnife = new TextureAtlas(Gdx.files.internal("kslashNorth.atlas"));
        knifeslashnorth = new Animation(0.1f, keldeNorthKnife.getRegions());
        keldeEastKnife = new TextureAtlas((Gdx.files.internal("kslashEast.atlas")));
        knifeslasheast = new Animation(0.1f, keldeEastKnife.getRegions());
        keldeSouthKnife = new TextureAtlas((Gdx.files.internal("kslashSouth.atlas")));
        knifeslashsouth = new Animation(0.1f, keldeSouthKnife.getRegions());
        keldeWestKnife = new TextureAtlas((Gdx.files.internal("kslashWest.atlas")));
        knifeslashwest = new Animation(0.1f, keldeWestKnife.getRegions());

    }

    private void createKeldeStanding() {
        keldeLookNorth = new TextureAtlas(Gdx.files.internal("keldelooknorth.atlas"));
        STANDING_STILL_NORTH = new Animation(0.1f, keldeLookNorth.getRegions());
        keldeLookEast = new TextureAtlas(Gdx.files.internal("keldelookeast.atlas"));
        STANDING_STILL_EAST = new Animation(0.1f, keldeLookEast.getRegions());
        keldeLookSouth = new TextureAtlas(Gdx.files.internal("keldelooksouth.atlas"));
        STANDING_STILL_SOUTH = new Animation(0.1f, keldeLookSouth.getRegions());
        keldeLookWest = new TextureAtlas(Gdx.files.internal("keldelookwest.atlas"));
        STANDING_STILL_WEST = new Animation(0.1f, keldeLookWest.getRegions());
    }

    private void createNorthTexture() {
        keldeWalkNorth = new TextureAtlas(Gdx.files.internal("kelde_walk.atlas"));
        animationWalkNorth = new Animation(0.07f, keldeWalkNorth.getRegions());
    }

    private void createWestTexture() {
        keldeWalkWest = new TextureAtlas(Gdx.files.internal("kelde_walk_west.atlas"));
        animationWalkWest = new Animation(0.07f, keldeWalkWest.getRegions());
    }

    private void createSouthTexture() {
        keldeWalkSouth = new TextureAtlas(Gdx.files.internal("kelde_walk_south.atlas"));
        animationWalkSouth = new Animation(0.07f, keldeWalkSouth.getRegions());
    }

    private void createEastTexture() {
        keldeWalkEast = new TextureAtlas(Gdx.files.internal("kelde_walk_east.atlas"));
        animationWalkEast = new Animation(0.07f, keldeWalkEast.getRegions());
    }

    public void renderTestPlayer() {
        // Testing temporary player for collisions

        animation = animationWalkNorth;
        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        float x = 0, y = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && !Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            y = 0.5f;
            animation = animationWalkNorth;
            direction = HEADING.NORTH;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && !Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            y = -0.5f;
            animation = animationWalkSouth;
            direction = HEADING.SOUTH;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            x = 0.5f;
            animation = animationWalkEast;
            direction = HEADING.EAST;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            x = -0.5f;
            animation = animationWalkWest;
            direction = HEADING.WEST;
        }
        if(!Gdx.input.isKeyPressed(Input.Keys.UP) && !Gdx.input.isKeyPressed(Input.Keys.DOWN) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if(direction == HEADING.NORTH) {
                animation = STANDING_STILL_NORTH;
            } else if (direction == HEADING.WEST) {
                animation = STANDING_STILL_WEST;
            } else if(direction == HEADING.EAST) {
                animation = STANDING_STILL_EAST;
            } else if(direction == HEADING.SOUTH) {
                animation = STANDING_STILL_SOUTH;
            }
        }
        ELAPSED_TIME1 += Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if(direction == HEADING.NORTH) {
                animation = knifeslashnorth;
            } else if (direction == HEADING.WEST) {
                animation = knifeslashwest;
            } else if(direction == HEADING.EAST) {
                animation = knifeslasheast;
            } else if(direction == HEADING.SOUTH) {
                animation = knifeslashsouth;
            }
        }
        body.setLinearVelocity(x, y);

        Sprite player = new Sprite(texture, 32, 48);
        player.setPosition(body.getPosition().x / BOX2D_SCALE - 16, body.getPosition().y / BOX2D_SCALE - 6);

        batch.begin();
        //player.draw(batch);
        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), body.getPosition().x / BOX2D_SCALE-32, body.getPosition().y / BOX2D_SCALE-6);
        batch.end();
        // End of temporary player
    }

    public void loadBat() {
        BodyDef batdef = new BodyDef();
        batdef.position.set(30*BOX2D_SCALE, 30*BOX2D_SCALE);
        batdef.type = BodyType.DynamicBody;
        bodybat = worldPhysics.getBox2dWorld().createBody(batdef);
        FixtureDef fbat = new FixtureDef();
        PolygonShape shapeBat = new PolygonShape();
        shapeBat.setAsBox(16 * BOX2D_SCALE, 8 * BOX2D_SCALE);
        fbat.shape = shapeBat;
        bodybat.createFixture(fbat);

        bat1.render(gameWorld.getCamera());
    }


}
