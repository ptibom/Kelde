/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameWorldView {
    private OrthogonalTiledMapRenderer renderer;

    public void render(float delta) {
        renderer.render();
    }

    public void dispose() {
        renderer.dispose();
    }

    public void setRenderer(OrthogonalTiledMapRenderer renderer) {
        this.renderer = renderer;
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

}
