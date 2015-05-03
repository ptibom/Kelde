package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import se.computerscience.kelde.controller.gameworld.GameWorldController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.physics.WorldPhysicsView;

/**
 * Created by Hossein on 2015-04-20.
 */
public class WorldObjectsView {


    private final float BOX2D_SCALE = 0.01f; // Exists in WorldPhysics, this is temporary for testing
    private Texture texture;
    private Body objBody;
    private boolean isMoveable;
    private Sprite objSprite;

    private GameWorldController gameWorldController;
    private GameWorldView gameWorldView;

    private WorldPhysics worldPhysics;
    private WorldPhysicsView worldPhysicsView;
    private WorldPhysicsController worldPhysicsController;
    private int x,y;
    private int spriteSizeX, spriteSizeY;
    private GameWorld gameWorld;




    public WorldObjectsView(boolean isMoveable, int x, int y) {
        this.isMoveable = isMoveable;
        this.x = x;
        this.y = y;
        //initWorld();
    }

    public void setSpriteSizeX(int spriteSizeX) {
        this.spriteSizeX = spriteSizeX;
    }

    public void setSpriteSizeY(int spriteSizeY) {
        this.spriteSizeY = spriteSizeY;
    }

    public void settexture(Texture texture) {
        this.texture = texture;
    }

    public Sprite getObjSprite() {
        return objSprite;
    }

    public void loadObj(WorldPhysics wp){
        BodyDef objBodyDef = new BodyDef();
        objBodyDef.position.set(x*BOX2D_SCALE,y*BOX2D_SCALE);

        if (isMoveable){
            objBodyDef.type = BodyDef.BodyType.DynamicBody;
        }
        else{
            objBodyDef.type = BodyDef.BodyType.StaticBody;
        }

        objBody = wp.getBox2dWorld().createBody(objBodyDef);
        FixtureDef objFixtureDef = new FixtureDef();
        PolygonShape objShape = new PolygonShape();
        objShape.setAsBox(16*BOX2D_SCALE, 16*BOX2D_SCALE);
        objFixtureDef.shape = objShape;
        objBody.createFixture(objFixtureDef);

        objFixtureDef.density = 500f;

    }

    public void render(){
        objSprite = new Sprite(texture, spriteSizeX, spriteSizeY);
        objSprite.setPosition(objBody.getPosition().x / BOX2D_SCALE - 16, objBody.getPosition().y / BOX2D_SCALE - 16);
        objBody.setLinearVelocity((float) (objBody.getLinearVelocity().x * 0.3), (float) (objBody.getLinearVelocity().y * 0.3));
    }
}
