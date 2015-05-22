/**
 * Description: Encapsulates Sprite from Model
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteEncaps implements ISprite{
    Sprite sprite;
    public SpriteEncaps(IRegion region){
        sprite = new Sprite(region.getRegion());
    }
    @Override
    public Sprite getSprite() {
        return sprite;
    }
}