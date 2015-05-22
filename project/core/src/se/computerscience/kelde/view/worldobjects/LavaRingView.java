/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.worldobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.worldobjects.LavaRing;

public class LavaRingView implements IWorldObjectView {
    private final LavaRing lavaRing;
    private Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 81, HEIGHT = 79;
    private final String SPRITE_LOCATION = "lava-obj.png";
    private final LavaSplashView[] lavaSplashView;
    public LavaRingView(LavaRing lavaRing) {
        this.lavaRing = lavaRing;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
        lavaSplashView = new LavaSplashView[lavaRing.getLavaSplash().length];

        for (int i = 0; i < lavaRing.getLavaSplash().length ; i++) {
            lavaSplashView[i] = new LavaSplashView(lavaRing.getLavaSplash()[i]);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setPosition(lavaRing.getPositionX(), lavaRing.getPositionY());
        sprite.draw(batch);

        for (int i = 0; i < lavaRing.getLavaSplash().length; i++) {
            lavaSplashView[i].draw(batch);
        }
    }
    public LavaSplashView[] getLavaSplashView() {
        return lavaSplashView;
    }
}