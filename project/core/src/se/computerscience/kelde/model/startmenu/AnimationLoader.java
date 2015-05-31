package se.computerscience.kelde.model.startmenu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public final class AnimationLoader {

    private final static int SPRITE_SIZE = 136;
    private final static int SPRITE_SHEET_SIZE = 42 / 3;
    private final static List<MenuAnimation> ALL_WALKING_ANIMATIONS = new ArrayList<>();
    private static int spreadsheetOffset = 138;
    private final static int SPRITE_SHEET_WIDTH = 830;
    private final static int SPRITE_SHEET_X_START = 2, SPRITE_SHEET_Y_START = 2;
    private final static int AMOUNT_PER_ROW = 3;
    private static List<MenuSprite> tempAnimationRegions;
    private static int x = SPRITE_SHEET_X_START;
    private static int y = SPRITE_SHEET_Y_START;

    private AnimationLoader() {

    }


    public static List<MenuAnimation> loadWalkingCharacters() {


        for (int i = 0; i < SPRITE_SHEET_SIZE; i++) {


            tempAnimationRegions = getArrayList();

            // Alogrithm for getting the coordinates for each sprite on the spritesheet
            for (int k = 0; k < AMOUNT_PER_ROW; k++) {

                if (x > SPRITE_SHEET_WIDTH) {
                    x = SPRITE_SHEET_X_START;
                    y += spreadsheetOffset;

                }
                tempAnimationRegions.add(createMenuSprite(x, y, SPRITE_SIZE, SPRITE_SIZE));
                x += spreadsheetOffset;
            }


            //Now that we have loaded an animation's textureRegions, we create an animation from it.
            // And then load it into our list of animations.
            ALL_WALKING_ANIMATIONS.add(getMenuAnimation(tempAnimationRegions));


        }

        Collections.shuffle(ALL_WALKING_ANIMATIONS);

        return ALL_WALKING_ANIMATIONS;
    }

    public static MenuSprite createMenuSprite(int xcord, int ycord, int spriteSizeWidth, int spriteSizeHeight) {
        return new MenuSprite(xcord, ycord, spriteSizeWidth, spriteSizeHeight);

    }

    public static List<MenuSprite> getArrayList() {
        return new ArrayList<>();
    }


    public static MenuAnimation getMenuAnimation(List<MenuSprite> listOfAnim) {

        return new MenuAnimation(listOfAnim);
    }

}