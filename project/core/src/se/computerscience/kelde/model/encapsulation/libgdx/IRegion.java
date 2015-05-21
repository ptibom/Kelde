/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public interface IRegion {
    public void setRegion(TextureAtlas.AtlasRegion region);
    public TextureAtlas.AtlasRegion getRegion();
}
