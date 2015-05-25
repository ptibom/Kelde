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

    //Variables
    private final LavaRing lavaRing;
    private final Sprite sprite;
    private final static int WIDTH = 81, HEIGHT = 79;
    private final static String SPRITE_LOCATION = "lava-obj.png";
    private final LavaSplashView[] lavaSplashView;

    //Constructor
    public LavaRingView(LavaRing lavaRing) {
        Texture texture;
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