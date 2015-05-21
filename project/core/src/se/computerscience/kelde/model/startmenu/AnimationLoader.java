package se.computerscience.kelde.model.startmenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class AnimationLoader {

    private int spriteSize = 136;
    private final int SPRITE_SHEET_SIZE = 42 / 3;
    StartMenu startMenuModel;
    List<Animation> allWalkingAnimations = new ArrayList<Animation>();
    private int spreadsheetOffset = 138;

    public AnimationLoader(StartMenu startMenuModel) {

        this.startMenuModel = startMenuModel;

    }


    public List<Animation> loadWalkingCharacters() {


        Texture walkingCharacterTexture = new Texture(startMenuModel.getWalkingCharacterPathPicture());


        for (int i = 0, x = 2, y = 2; i < SPRITE_SHEET_SIZE; i++) {
            TextureRegion[] tempAnimationRegions = new TextureRegion[3];
            if (x > 830) {
                x = 2;
                y += spreadsheetOffset;

            }
            tempAnimationRegions[0] = new TextureRegion(walkingCharacterTexture, x, y, spriteSize, spriteSize);

            x += spreadsheetOffset;

            if (x > 830) {
                x = 2;
                y += spreadsheetOffset;

            }
            tempAnimationRegions[1] = new TextureRegion(walkingCharacterTexture, x, y, spriteSize, spriteSize);
            ;

            x += spreadsheetOffset;

            if (x > 830) {
                x = 2;
                y += spreadsheetOffset;

            }
            tempAnimationRegions[2] = new TextureRegion(walkingCharacterTexture, x, y, spriteSize, spriteSize);

            x += spreadsheetOffset;

            //Now that we have loaded an animation's textureRegions, we create an animation from it.
            // And then load it into our list of animations.
            allWalkingAnimations.add(new Animation(0.27f, tempAnimationRegions));


        }

        Collections.shuffle(allWalkingAnimations);

        return allWalkingAnimations;
    }
}