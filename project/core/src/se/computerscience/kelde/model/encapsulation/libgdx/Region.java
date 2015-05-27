/**
 * Description: Encapsulates AtlasRegion from Model
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Region implements IRegion {
    private TextureAtlas.AtlasRegion atlasRegion;
    public Region(IAtlas atlas){
        atlasRegion = atlas.findRegion("");
    }
    @Override
    public void setRegion(TextureAtlas.AtlasRegion atlasRegion){
        this.atlasRegion = atlasRegion;
    }
    @Override
    public TextureAtlas.AtlasRegion getRegion() {
        return atlasRegion;
    }
}