package se.computerscience.kelde.model.startmenu;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class AnimationLoader {

    private final static int spriteSize = 136;
    private final static int SPRITE_SHEET_SIZE = 42 / 3;
    private final static List<MenuAnimation> allWalkingAnimations = new ArrayList<>();
    private static int spreadsheetOffset = 138;
    private final static int SPRITE_SHEET_WIDTH = 830;
    private final static int SPRITE_SHEET_X_START = 2, SPRITE_SHEET_Y_START = 2;
    private final static int AMOUNT_PER_ROW = 3;
    private final static float ANIMATION_LENGTH = 0.27f;

    public AnimationLoader() {

    }

    public static List<MenuAnimation> loadWalkingCharacters() {


        for (int i = 0, x = SPRITE_SHEET_X_START, y = SPRITE_SHEET_Y_START; i < SPRITE_SHEET_SIZE; i++) {

           List<MenuSprite> tempAnimationRegions = new ArrayList<>();


            // Alogrithm for getting the coordinates for each sprite on the spritesheet
            for(int k = 0; k<AMOUNT_PER_ROW;k++) {

                if (x > SPRITE_SHEET_WIDTH) {
                    x = SPRITE_SHEET_X_START;
                    y += spreadsheetOffset;

                }
                tempAnimationRegions.add(new MenuSprite(x, y, spriteSize, spriteSize));
                x += spreadsheetOffset;
            }


            //Now that we have loaded an animation's textureRegions, we create an animation from it.
            // And then load it into our list of animations.
            allWalkingAnimations.add( new MenuAnimation(tempAnimationRegions));


        }

        Collections.shuffle(allWalkingAnimations);

        return allWalkingAnimations;
    }


}