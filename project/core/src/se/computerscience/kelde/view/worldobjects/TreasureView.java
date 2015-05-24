package se.computerscience.kelde.view.worldobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.worldobjects.Treasure;

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class TreasureView implements IWorldObjectView {
    private final Treasure treasure;
    private static final int WIDTH = 30, HEIGHT = 32;
    private static final String SPRITE_LOCATION1 = "chest1.png";
    private static final String SPRITE_LOCATION2 = "chest2.png";
    private Sprite sprite;
    private final Sprite SPRITE_OPENED;
    private final Sprite SPRITE_CLOSED;

    public TreasureView(Treasure treasure) {
        Texture texture;
        this.treasure = treasure;
        texture = new Texture(SPRITE_LOCATION1);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
        SPRITE_CLOSED = new Sprite(new Texture(SPRITE_LOCATION2), WIDTH, HEIGHT);
        SPRITE_OPENED = new Sprite(new Texture(SPRITE_LOCATION1), WIDTH, HEIGHT);
    }

    public void update(float delta) {
        if (treasure.isCheastOpen()) {
            sprite = SPRITE_OPENED;
        }
        else {
            sprite = SPRITE_CLOSED;
        }
    }

    @Override
    public void draw (SpriteBatch batch) {
        sprite.setPosition(treasure.getPositionX(), treasure.getPositionY());
        sprite.draw(batch);
    }
}