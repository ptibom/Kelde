package se.computerscience.kelde.view.intro;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import se.computerscience.kelde.model.intro.IntroAnimation;
import se.computerscience.kelde.model.intro.IntroSpriteFrame;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AnimationConverter

{
    // Converts an set of in house introAnimations  to a set of  Libgdx animations.
    public static Map<String,Animation> convertToLibgdxAnimation( Map<String, IntroAnimation> animationToConvert , float animationLength,
                                                           Texture spriteTexture){

        Map<String,Animation> convertedAnimation = new HashMap<>();
        Iterator introAnimations = animationToConvert.entrySet().iterator();

        while(introAnimations.hasNext()){

            Map.Entry anEntry = (Map.Entry) introAnimations.next();
            String key = (String) anEntry.getKey();
            IntroAnimation introAnimation = (IntroAnimation) anEntry.getValue();


            Array<TextureRegion> loadingTextureRegion = new Array<>();
            for(IntroSpriteFrame aSprite : introAnimation.getIntroSpriteFrames()){

                loadingTextureRegion.add(new TextureRegion(spriteTexture, aSprite.spriteStartXPosition(),
                        aSprite.getSpriteStartYPosition(), aSprite.getSpriteWidth(), aSprite.getSpriteWidth()));
            }

            convertedAnimation.put(key, new Animation(animationLength, loadingTextureRegion));

        }




        return convertedAnimation;
    }



}
