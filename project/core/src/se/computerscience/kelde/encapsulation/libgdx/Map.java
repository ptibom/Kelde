/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.encapsulation.libgdx;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Map implements IMap {
    private final TiledMap tiledMap;

    public Map(String fileName) {
        tiledMap = new TmxMapLoader().load(fileName);
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
