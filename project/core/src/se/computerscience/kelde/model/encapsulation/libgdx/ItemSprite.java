/**
 * Description: Encapsulates Sprite from Model
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class ItemSprite implements ISprite {
    private final Sprite sprite;

    public ItemSprite(IRegion region) {
        sprite = new Sprite(region.getRegion());
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }
}