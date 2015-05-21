/**
	Description: Main game class where everything starts.
	@author: Philip Tibom
*/
package se.computerscience.kelde;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import se.computerscience.kelde.controller.events.IScreenEventHandler;
import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.controller.events.ScreenEventBus;
import se.computerscience.kelde.screens.GameScreen;

public class KeldeGame extends Game implements IScreenEventHandler {
	/** Called when application is created */
	@Override
	public void create () {
        ScreenEventBus.INSTANCE.register(this);
		setScreen(new GameScreen());
	}

	@Override
	public void onScreenChange(ScreenEvent event) {
        if (ScreenEvent.Tag.SET_SCREEN == event.getTag()) {
            if (event.getObject() instanceof Screen) {
                Screen newScreen = (Screen) event.getObject();
                setScreen(newScreen);
            }
        }
	}

    public void dispose() {
        ScreenEventBus.INSTANCE.unregister(this);
    }
}
