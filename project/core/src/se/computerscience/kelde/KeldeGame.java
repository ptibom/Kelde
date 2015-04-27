/*
	Description: Main game class where everything starts.
	@author: Philip Tibom
 */
package se.computerscience.kelde;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.view.MapScreen;


public class KeldeGame extends Game {
	private OrthographicCamera camera;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMap map;
	
	@Override
	public void create () {
		setScreen(new MapScreen());
	}


}
