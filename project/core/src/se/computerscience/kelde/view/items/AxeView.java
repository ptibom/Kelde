package se.computerscience.kelde.view.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import se.computerscience.kelde.model.items.AxeModel;

/**
 * Created by Hassan on 2015-05-05.
 */
public class AxeView {
    private final AxeModel axeModel;
    private final Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 32;
    private TextureAtlas atlas;
    private final String SPRITE_LOCATION = "items.atlas";
    private boolean visble = false;

    public AxeView(AxeModel axeModel) {
        this.axeModel = axeModel;
        atlas = new TextureAtlas(SPRITE_LOCATION);
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);

    }

    public void draw (SpriteBatch batch) {
        sprite.setPosition(axeModel.getPositionX(), axeModel.getPositionY());
        sprite.draw(batch);
    }

    public boolean isVisble() {
        return visble;
    }

    public void setVisble(boolean visble) {
        this.visble = visble;
    }
}
