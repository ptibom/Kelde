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
    private final LavaSplash lavaSplash;
    private final Sprite sprite;
    private static final int WIDTH = 24, HEIGHT = 27;
    private static final String SPRITE_LOCATION = "lava-splash.png";

    public LavaSplashView(LavaSplash lavaSplash) {
        Texture texture;
        this.lavaSplash = lavaSplash;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setPosition(lavaSplash.getPositionX(), lavaSplash.getPositionY());
        sprite.draw(batch);
    }
}