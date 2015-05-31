package se.computerscience.kelde.view.worldobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.worldobjects.Barrel;

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class BarrelView implements IWorldObjectView {
    private final Barrel barrel;
    private final Sprite sprite;
    private static final int WIDTH = 32, HEIGHT = 48;
    private static final String SPRITE_LOCATION = "barrel.png";

    public BarrelView(Barrel barrel) {
        this.barrel = barrel;
        final Texture texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }

    public void update(float delta) {
        // not used
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setPosition(barrel.getPositionX(), barrel.getPositionY());
        sprite.draw(batch);
    }

}
