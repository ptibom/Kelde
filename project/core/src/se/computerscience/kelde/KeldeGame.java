/**
 * Description: Main game class where everything starts.
 *
 * @author: Philip Tibom
 */
package se.computerscience.kelde;

import com.badlogic.gdx.Game;
import se.computerscience.kelde.controller.events.IScreenEventHandler;
import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.controller.events.ScreenEventBus;
import se.computerscience.kelde.screens.GameScreen;
import se.computerscience.kelde.screens.IntroScreen;
import se.computerscience.kelde.screens.MenuScreen;

public class KeldeGame extends Game implements IScreenEventHandler {


    /** Called when application is created */
    @Override
    public void create() {
        ScreenEventBus.INSTANCE.register(this);
        setScreen(new MenuScreen());
    }

    @Override
    public void onScreenChange(ScreenEvent event) {
        if (ScreenEvent.Tag.SET_SCREEN == event.getTag()) {
            switch (event.getScreenTag()) {
                case START_WORLD:
                    setScreen(new GameScreen());
                    break;
                case INTRO:
                    setScreen(new IntroScreen());
                    break;
                case START_MENU:
                    setScreen(new MenuScreen());
                    break;
                default:
                    break;
            }
        }
    }

    public void dispose() {
        ScreenEventBus.INSTANCE.unregister(this);
    }
}
