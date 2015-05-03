/**
 * Description: Separates frameowork from model.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.libgdx;

import com.badlogic.gdx.maps.tiled.TiledMap;

public interface IMap {
    public TiledMap getTiledMap();
    public void dispose();
}
