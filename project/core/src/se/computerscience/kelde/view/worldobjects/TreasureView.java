package se.computerscience.kelde.view.worldobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.worldobjects.Treasure;
import se.computerscience.kelde.view.items.AxeView;
import se.computerscience.kelde.view.items.SwordView;

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class TreasureView implements IWorldObjectView {
    private final Treasure treasure;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 32;
    private final String SPRITE_LOCATION1 = "chest1.png";
    private final String SPRITE_LOCATION2 = "chest2.png";
    private Sprite sprite;
    private final Sprite SPRITE_OPENED;
    private final Sprite SPRITE_CLOSED;

    private SwordView swordView;
    private AxeView axeView;
    public TreasureView(Treasure treasure) {
        this.treasure = treasure;
        texture = new Texture(SPRITE_LOCATION1);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
        SPRITE_CLOSED = new Sprite(new Texture(SPRITE_LOCATION2), 30, 32);
        SPRITE_OPENED = new Sprite(new Texture(SPRITE_LOCATION1), 30, 32);

        swordView = new SwordView(treasure.getSword());
        axeView = new AxeView(treasure.getAxe());
    }

    public void update(float delta) {
        if (treasure.isOpen()) {
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

        if (swordView.isVisble()){
            swordView.draw(batch);
        }
        if (axeView.isVisble()){
            axeView.draw(batch);
        }
    }

    public SwordView getSwordView() {
        return swordView;
    }

    public AxeView getAxeView() {
        return axeView;
    }
}
