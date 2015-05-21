/**
	Description: Main game class where everything starts.
	@author: Philip Tibom
*/
package se.computerscience.kelde;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import se.computerscience.kelde.events.IScreenEventHandler;
import se.computerscience.kelde.events.ScreenEvent;
import se.computerscience.kelde.events.ScreenEventBus;
import se.computerscience.kelde.screens.GameScreen;
import se.computerscience.kelde.screens.BasicScreen;
import se.computerscience.kelde.screens.LavaScreen;

public class KeldeGame extends Game implements IScreenEventHandler {
    Screen currentScreen;

	/** Called when application is created */
	@Override
	public void create () {
        ScreenEventBus.INSTANCE.register(this);
        currentScreen = new GameScreen();
		setScreen(currentScreen);
	}

	@Override
	public void onScreenChange(ScreenEvent event) {
        if (ScreenEvent.Tag.SET_SCREEN == event.getTag()) {
            ((GameScreen)currentScreen).cleanEventBuses();
            switch (event.getScreenTag()) {
                case START_WORLD:
                    setScreen(new GameScreen());
                    break;
                case  LAVA_WORLD:
                    setScreen(new LavaScreen());
                    break;
            }
        }
	}

    public void dispose() {
        ScreenEventBus.INSTANCE.unregister(this);
    }
}
