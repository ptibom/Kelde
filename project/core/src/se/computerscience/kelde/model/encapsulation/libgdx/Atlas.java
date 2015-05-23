/**
 * Description: Encapsulates TextureAtlas from Model
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.libgdx;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Atlas implements IAtlas{
    TextureAtlas textureAtlas;
    public Atlas(String fileName){
        textureAtlas = new TextureAtlas(Gdx.files.internal(fileName));
    }
    @Override
    public TextureAtlas.AtlasRegion findRegion(String region){
        return textureAtlas.findRegion(region);
    }
    @Override
    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }
}