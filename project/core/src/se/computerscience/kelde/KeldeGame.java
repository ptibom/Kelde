/**
	Description: Main game class where everything starts.
	@author: Philip Tibom
*/
package se.computerscience.kelde;

import com.badlogic.gdx.Game;
import se.computerscience.kelde.view.screens.MenuScreen;

public class KeldeGame extends Game {

	/** Called when application is created */
	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}


}
