package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.startmenu.AnimationLoader;
import se.computerscience.kelde.model.startmenu.StartMenu;

import java.util.List;

/**
 * @author: Daniel Olsson
 */

// This class takes care of handling the menu animations
public class MenuAnimationHandler {

    private static final int MOVEMENT_SPEED = 18, ORIGIN_X = -2400, ORIGIN_Y = 70;
    private static final int CHARACTER_OFFSET = 300;
    private final StartMenu startMenuModel;
    private final List<Animation> allWalkingAnimations;


    public MenuAnimationHandler(StartMenu startMenuModel) {

        this.startMenuModel = startMenuModel;

        allWalkingAnimations = MenuAnimationConverter.menuAnimToLibAnim(AnimationLoader.loadWalkingCharacters(),
                new Texture(startMenuModel.getWalkingCharacterPathPicture()));

    }


    // Draws out all the characters walking in the intro scene
    public void drawMenuAnimations(SpriteBatch batch) {


        for (int i = 0; i < allWalkingAnimations.size(); i++) {

            batch.draw(allWalkingAnimations.get(i).getKeyFrame(startMenuModel.getStateTime(), true),
                    ORIGIN_X + CHARACTER_OFFSET * i + (startMenuModel.getStateTime()) * MOVEMENT_SPEED, ORIGIN_Y, 64, 64);
        }

    }


}
