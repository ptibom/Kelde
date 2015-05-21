/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public interface IAtlas {
    public TextureAtlas.AtlasRegion findRegion(String region);
    public TextureAtlas getTextureAtlas();
}