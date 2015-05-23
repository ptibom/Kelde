/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.worldobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import se.computerscience.kelde.model.worldobjects.CampFire;

public class CampFireView implements IWorldObjectView {
    private final static String SPRITE_LOCATION = "CampFire.atlas";
    private final CampFire campFire;
    private TextureAtlas textureAtlas;
    private Animation animation;
    private float elapsedTime = 0, delta = 0;


    public CampFireView(CampFire campFire) {
        this.campFire = campFire;
        textureAtlas = new TextureAtlas(Gdx.files.internal(SPRITE_LOCATION));
        animation = new Animation(0.15f, textureAtlas.getRegions());
    }
    @Override
    public void draw (SpriteBatch batch) {
        elapsedTime += delta;
        if (elapsedTime >= 10f){
            elapsedTime = 0;
        }
        batch.draw(animation.getKeyFrame(elapsedTime, true), campFire.getPositionX(), campFire.getPositionY());
    }
    public void update(float delta) {
        this.delta = delta;
    }
}