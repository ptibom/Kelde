package se.computerscience.kelde.view.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.items.SwordModel;

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class SwordView {
    private final SwordModel swordModel;
    private final Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 32;
    private final String SPRITE_LOCATION = "items.png";
    private boolean visble = false;

    public SwordView(SwordModel swordModel) {
        this.swordModel = swordModel;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }

    public void draw (SpriteBatch batch) {
        sprite.setPosition(swordModel.getPositionX(), swordModel.getPositionY());
        sprite.draw(batch);
    }

    public boolean isVisble() {
        return visble;
    }
    public void setVisble(boolean visble) {
        this.visble = visble;
    }
}