package se.computerscience.kelde.view.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.items.Axe;

/**
 * Description:
 * @author: Hossein Hussain
 */
public class AxeView implements IItemView{
    //private final Axe axe;
    private final Sprite sprite;
    //private final Texture texture;
    private final int WIDTH = 25, HEIGHT = 29;
    private final String SPRITE_LOCATION = "axe_1.png";

    public AxeView(/*Axe axe*/) {
        //this.axe = axe;
        //texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(new Texture(SPRITE_LOCATION), WIDTH, HEIGHT);
    }
    @Override
    public void draw (SpriteBatch batch) {
    /*    sprite.setPosition(axe.getPositionX(), axe.getPositionY());
        if (axe.isVisible() && !axe.isPicked()){
            sprite.draw(batch);
        }*/
    }

    public Sprite getSprite() {
        return sprite;
    }
}