package se.computerscience.kelde.view.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.items.AxeModel;

/**
 * Description:
 * @author: Hossein Hussain
 */
public class AxeView implements IItemView{
    private final AxeModel axeModel;
    private final Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 25, HEIGHT = 29;
    private final String SPRITE_LOCATION = "axe_1.png";
    private boolean visble = false;

    public AxeView(AxeModel axeModel) {
        this.axeModel = axeModel;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }
    @Override
    public void draw (SpriteBatch batch) {
        sprite.setPosition(axeModel.getPositionX(), axeModel.getPositionY());
        sprite.draw(batch);
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