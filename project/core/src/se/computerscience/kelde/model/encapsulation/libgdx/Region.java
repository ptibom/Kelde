/**
 * Description: Encapsulates AtlasRegion from Model
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Region implements IRegion {
    TextureAtlas.AtlasRegion region;
    public Region(Atlas atlas){
        region = atlas.findRegion("");
    }
    @Override
    public void setRegion(TextureAtlas.AtlasRegion region){
        this.region = region;
    }
    @Override
    public TextureAtlas.AtlasRegion getRegion() {
        return region;
    }
}