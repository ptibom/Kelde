package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.startmenu.AnimationLoader;
import se.computerscience.kelde.model.startmenu.StartMenu;

import java.util.List;

/**
 * @author: Daniel Olsson
 */
public class MenuAnimationHandler {

    private final int MOVEMENT_SPEED = 18;
    private final StartMenu startMenuModel;
    private SpriteBatch batch;
    private final AnimationLoader animationloader;
    private final List<Animation> allWalkingAnimations;


    public MenuAnimationHandler(StartMenu startMenuModel, AnimationLoader animationLoader) {

        this.startMenuModel = startMenuModel;
        this.animationloader = animationLoader;
        allWalkingAnimations = animationloader.loadWalkingCharacters();

    }


    // Draws out all the characters walking in the intro scene
    public void drawMenuAnimations(SpriteBatch batch) {

        this.batch = batch;

        for (int i = 0; i < allWalkingAnimations.size(); i++) {

            TextureRegion currentFrame = allWalkingAnimations.get(i).getKeyFrame(startMenuModel.getStateTime(), true);
            this.batch.draw(currentFrame, -2400 + 300 * i + (startMenuModel.getStateTime()) * MOVEMENT_SPEED, 130);
        }


    }


}
