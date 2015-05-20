/**
	Description: Main game class where everything starts.
	@author: Philip Tibom
*/
package se.computerscience.kelde;

import com.badlogic.gdx.Game;
import se.computerscience.kelde.screens.GameScreen;

import se.computerscience.kelde.screens.MenuScreen;


public class KeldeGame extends Game {
	GameScreen gameScreen;
	/** Called when application is created */
	@Override
	public void create () {
		gameScreen = new GameScreen();

		setScreen(new MenuScreen (this));


	}
}
