package se.computerscience.kelde.controller.startmenu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
public class StartMenuController {

    private final StartMenu startMenuModel;
    private final StartMenuView startMenuView;

    public StartMenuController() throws IOException {
        startMenuModel = new StartMenu();
        this.startMenuView = new StartMenuView(startMenuModel);
        startMenuView.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                ScreenEventBus.INSTANCE.publish(new ScreenEvent(ScreenEvent.Tag.SET_SCREEN, ScreenEvent.ScreenTag.INTRO));
            }
        });
        startMenuView.getLoadButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {

            }
        });





        startMenuView.addActors();

    }


    public void render( float delta) {

         startMenuView.renderMenu( delta);


    }

    public void resize(int width, int height){
        startMenuView.resize(width, height);
    }



}
