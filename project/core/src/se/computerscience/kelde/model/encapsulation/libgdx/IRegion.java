/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public interface IRegion {
    void setRegion(TextureAtlas.AtlasRegion region);
    TextureAtlas.AtlasRegion getRegion();
}