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
import se.computerscience.kelde.model.worldobjects.LavaSplash;

import java.util.ArrayList;
import java.util.List;

public class LavaRingView implements IWorldObjectView {

    //Variables
    private final LavaRing lavaRing;
    private final Sprite sprite;
    private final static int WIDTH = 81, HEIGHT = 79;
    private final static String SPRITE_LOCATION = "lava-obj.png";
    private final List<LavaSplashView> lavaSplashViews = new ArrayList<>();

    //Constructor
    public LavaRingView(LavaRing lavaRing) {
        Texture texture;
        this.lavaRing = lavaRing;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);

        for (final LavaSplash lavaSplash : lavaRing.getLavaSplashs()) {
            lavaSplashViews.add(setLavaSplashViews(lavaSplash));
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setPosition(lavaRing.getPositionX(), lavaRing.getPositionY());
        sprite.draw(batch);

        for (final LavaSplashView lavaSplashView : lavaSplashViews) {
            lavaSplashView.draw(batch);
        }
    }

    public LavaSplashView setLavaSplashViews(LavaSplash lavaSplash) {
        return new LavaSplashView(lavaSplash);
    }

    public List<LavaSplashView> getLavaSplashViews() {
        return lavaSplashViews;
    }
}