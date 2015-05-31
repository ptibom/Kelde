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
    private static final String SPRITE_LOCATION = "CampFire.atlas";
    private final CampFire campFire;
    private float elapsedTime, delta;


    public CampFireView(CampFire campFire) {
        this.campFire = campFire;

    }

    @Override
    public void draw(SpriteBatch batch) {
        final TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal(SPRITE_LOCATION));
        final Animation animation = new Animation(0.15f, textureAtlas.getRegions());
        elapsedTime += delta;
        if (elapsedTime >= 10f) {
            elapsedTime = 0;
        }
        batch.draw(animation.getKeyFrame(elapsedTime, true), campFire.getPositionX(), campFire.getPositionY());
    }

    public void update(float delta) {
        this.delta = delta;
    }
}