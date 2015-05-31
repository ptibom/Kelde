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
import se.computerscience.kelde.model.worldobjects.Bomb;

public class BombView implements IWorldObjectView {
    private final Bomb bomb;
    private static final String SPRITE_LOCATION = "BombExploding.atlas";
    private boolean display = true;
    private final Animation animation;
    private float elapsedTime, delta;

    public BombView(Bomb bomb) {
        this.bomb = bomb;
        final TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal(SPRITE_LOCATION));
        animation = new Animation(0.15f, textureAtlas.getRegions());
    }

    @Override
    public void draw(SpriteBatch batch) {
        elapsedTime += delta;
        if (elapsedTime >= 1.5f) {
            bomb.setDetonate(false);
            stopAnimation();
            display = false;
        }
        if (display) {
            batch.draw(animation.getKeyFrame(elapsedTime, true), bomb.getPositionX(), bomb.getPositionY());
        }
    }

    public void update(float delta) {
        this.delta = delta;
    }

    public void stopAnimation() {
        this.delta = 0;
        this.elapsedTime = 0;
        bomb.destroy();
        bomb.getBombArea().destroy();
    }
}