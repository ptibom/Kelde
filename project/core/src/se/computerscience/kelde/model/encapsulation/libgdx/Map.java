/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Map implements IMap {
    private final TiledMap tiledMap;

    public Map(String fileName) {
        TmxMapLoader.Parameters parameters = new TmxMapLoader.Parameters();
        parameters.textureMinFilter = Texture.TextureFilter.Linear;
        parameters.textureMagFilter = Texture.TextureFilter.MipMapLinearNearest;
        tiledMap = new TmxMapLoader().load(fileName, parameters);
    }

    @Override
    public TiledMap getTiledMap() {
        return tiledMap;
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
    }
}
