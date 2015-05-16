/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.worldobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import se.computerscience.kelde.model.worldobjects.Bomb;

public class BombView implements IWorldObjectView {
    private final Bomb bomb;
    private final String SPRITE_LOCATION = "BombExploding.atlas";
    private boolean display = true;

    private TextureAtlas textureAtlas;
    private Animation animation;
    private float elapsedTime = 0, delta = 0;

    public BombView(Bomb bomb) {
        this.bomb = bomb;
        textureAtlas = new TextureAtlas(Gdx.files.internal(SPRITE_LOCATION));
        animation = new Animation(0.15f, textureAtlas.getRegions());
    }
    @Override
    public void draw (SpriteBatch batch) {
        elapsedTime += delta;
        if (elapsedTime >= 1.5f){
            bomb.setDetonate(false);
            stopAnimation();
            display = false;
        }
        if (display){
            batch.draw(animation.getKeyFrame(elapsedTime, true), bomb.getPositionX(), bomb.getPositionY());
        }
    }
    public void update(float delta) {
        this.delta = delta;
    }
    public void stopAnimation(){
        this.delta = 0;
        this.elapsedTime  = 0;
        bomb.destroy();
        bomb.getBombArea().destroy();
    }
}