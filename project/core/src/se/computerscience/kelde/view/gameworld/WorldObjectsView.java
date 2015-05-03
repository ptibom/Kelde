package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
/**
 * Created by Hossein on 2015-04-20.
 */
public class WorldObjectsView {
    private final float BOX2D_SCALE = 0.01f; // Exists in WorldPhysics, this is temporary for testing
    private Texture texture ;
    private Body objBody;
    private Sprite objSprite;
    private int spriteSizeX, spriteSizeY;

    public WorldObjectsView(Body objBody) {
        this.objBody = objBody;
    }

    public void render(){
        objSprite = new Sprite(texture, spriteSizeX, spriteSizeY);
        objSprite.setPosition(objBody.getPosition().x / BOX2D_SCALE - 16, objBody.getPosition().y / BOX2D_SCALE - 16);
        objBody.setLinearVelocity((float) (objBody.getLinearVelocity().x * 0.3), (float) (objBody.getLinearVelocity().y * 0.3));
    }

    public void resize (int height, int width, OrthographicCamera camera) {}

    public void setSpriteSizeX(int spriteSizeX) {
        this.spriteSizeX = spriteSizeX;
    }
    public void setSpriteSizeY(int spriteSizeY) {
        this.spriteSizeY = spriteSizeY;
    }
    public Sprite getObjSprite() {
        return objSprite;
    }
    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
