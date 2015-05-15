package se.computerscience.kelde.view.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.items.Sword;

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class SwordView implements IItemView {
    private final Sword sword;
    private final Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 29, HEIGHT = 29;
    private final String SPRITE_LOCATION = "sword_1.png";
    private boolean visble = false;

    public SwordView(Sword sword) {
        this.sword = sword;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }
    @Override
    public void draw (SpriteBatch batch) {
        sprite.setPosition(sword.getPositionX(), sword.getPositionY());
        sprite.draw(batch);
        if (sword.isPicked()){
            sword.destroy();
        }
    }
    @Override
    public boolean isVisble() {
        return visble;
    }
    @Override
    public void setVisble(boolean visble) {
        this.visble = visble;
    }
}