package se.computerscience.kelde.controller.startmenu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.controller.events.ScreenEventBus;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.startmenu.StartMenuView;

import java.io.IOException;

/**
 * @author: Daniel Olsson
 */

// Gets callback from intro to for instance change screen.
public class StartMenuController {

    private final StartMenuView startMenuView;

    public StartMenuController() throws IOException {
         final StartMenu startMenuModel = new StartMenu();
        this.startMenuView = new StartMenuView(startMenuModel);
        startMenuView.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                startMenuView.stopMusic();
                ScreenEventBus.INSTANCE.publish(new ScreenEvent(ScreenEvent.Tag.SET_SCREEN, ScreenEvent.ScreenTag.INTRO));
            }
        });
        startMenuView.getLoadButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                startMenuView.stopMusic();
                ScreenEventBus.INSTANCE.publish(new ScreenEvent(ScreenEvent.Tag.SET_SCREEN, ScreenEvent.ScreenTag.START_WORLD));

            }
        });
    }

    public void render(float delta) {

        startMenuView.renderMenu(delta);

    }
// The window need to be resized
    public void resize(int width, int height) {
        startMenuView.resize(width, height);
    }

}
