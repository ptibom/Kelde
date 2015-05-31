package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.startmenu.MenuAnimation;
import se.computerscience.kelde.model.startmenu.MenuSprite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

// Converts in house animation data to libgdx animations
public final class MenuAnimationConverter {

    private static List<Animation> convertedAnimations;
    private static TextureRegion[] allFramesinAnimation;

    private MenuAnimationConverter() {

    }

    public static List<Animation> menuAnimToLibAnim(List<MenuAnimation> menuAnimations, Texture spriteSheetTexture) {

        convertedAnimations = new ArrayList<>();

        for (final MenuAnimation anAnimation : menuAnimations) {


            allFramesinAnimation = getTextureRegionSizeThree();
            for (int i = 0; i < 3; i++) {
                final MenuSprite sprite = anAnimation.getMenuSpriteFrames().get(i);
                allFramesinAnimation[i] = getTextureRegion(spriteSheetTexture, sprite);
            }

            convertedAnimations.add(getAnimation(allFramesinAnimation));
        }

        return convertedAnimations;

    }

    private static TextureRegion getTextureRegion(Texture spriteSheetTexture, MenuSprite sprite) {

        return new TextureRegion(spriteSheetTexture, sprite.getSpriteStartXPosition(), sprite.getSpriteStartYPosition(),
                sprite.getSpriteWidth(), sprite.getSpriteHeight());

    }

    private static Animation getAnimation(TextureRegion[] textReg) {

        return new Animation(0.27f, textReg);
    }

    private static TextureRegion[] getTextureRegionSizeThree() {
        return new TextureRegion[3];
    }
}
