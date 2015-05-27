package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.startmenu.MenuAnimation;
import se.computerscience.kelde.model.startmenu.MenuSprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MonoMan on 5/24/2015.
 */
public class MenuAnimationConverter {


    // Conoverting a in-house menu animation to libgdx animation
    public static List<Animation> menuAnimToLibAnim(List<MenuAnimation> menuAnimations, Texture spriteSheetTexture) {

        List<Animation> convertedAnimations = new ArrayList<>();
        convertedAnimations = new ArrayList<>();

        for (MenuAnimation anAnimation : menuAnimations) {


            TextureRegion[] allFramesinAnimation = new TextureRegion[3];
            for (int i = 0; i < 3; i++) {
                MenuSprite sprite = anAnimation.getMenuSpriteFrames().get(i);
                allFramesinAnimation[i] = (new TextureRegion(spriteSheetTexture, sprite.getSpriteStartXPosition(), sprite.getSpriteStartYPosition(),
                        sprite.getSpriteWidth(), sprite.getSpriteHeight()));
            }

            convertedAnimations.add(new Animation(0.27f, (TextureRegion[]) allFramesinAnimation));
        }

        return convertedAnimations;

    }


}
