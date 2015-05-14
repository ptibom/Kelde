/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.worldobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.worldobjects.LavaSplash;

public class LavaSplashView implements IWorldObjectView {
    private LavaSplash lavaSplash;
    private Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 24, HEIGHT = 27;
    private final String SPRITE_LOCATION = "lavasplash.png";

    public LavaSplashView(LavaSplash lavaSplash) {
        this.lavaSplash = lavaSplash;

        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setPosition(lavaSplash.getPositionX(), lavaSplash.getPositionY());
        sprite.draw(batch);
    }
    public void setPos(float x,float y){
        sprite.setPosition(x,y);
    }
}