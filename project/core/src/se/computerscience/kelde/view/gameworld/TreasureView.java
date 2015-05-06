package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.gameworld.TreasureModell;
/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class TreasureView implements IWorldObjectView {
    private final TreasureModell treasureModell;
    private Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 32;
    private final String SPRITE_LOCATION = "chest2.png";

    public TreasureView(TreasureModell treasureModell) {
        this.treasureModell = treasureModell;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }
    @Override
    public void draw (SpriteBatch batch) {
        sprite.setPosition(treasureModell.getPositionX(), treasureModell.getPositionY());
        sprite.draw(batch);
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
