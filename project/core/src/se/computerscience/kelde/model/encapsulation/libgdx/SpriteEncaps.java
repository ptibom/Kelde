/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteEncaps implements ISprite{
    Sprite sprite;
    public SpriteEncaps(Region region){
        sprite = new Sprite(region.getRegion());
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }
}