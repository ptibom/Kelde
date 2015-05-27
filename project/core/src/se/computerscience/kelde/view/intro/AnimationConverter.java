package se.computerscience.kelde.view.intro;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import se.computerscience.kelde.model.intro.IntroAnimation;
import se.computerscience.kelde.model.intro.IntroSpriteFrame;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class AnimationConverter

{ private AnimationConverter(){

}
    // Converts an set of in house introAnimations  to a set of  Libgdx animations.
    public static Map<String,Animation> convertToLibgdxAnimation( Map<String, IntroAnimation> animationToConvert , float animationLength,
                                                                  Texture spriteTexture){



        final Map<String,Animation> convertedAnimation = new HashMap<>();
        final Iterator introAnimations = animationToConvert.entrySet().iterator();

        while(introAnimations.hasNext()){

            final Map.Entry anEntry = (Map.Entry) introAnimations.next();
            final  String key = (String) anEntry.getKey();
            final IntroAnimation introAnimation = (IntroAnimation) anEntry.getValue();


            final  Array<TextureRegion> loadingTextureRegion = getArray();
            for(final IntroSpriteFrame aSprite : introAnimation.getIntroSpriteFrames()){

                loadingTextureRegion.add(getTextureRegion(aSprite,spriteTexture));
            }

            convertedAnimation.put(key,getAnimation(animationLength,loadingTextureRegion ));

        }


        return convertedAnimation;
    }


    public static Animation getAnimation(float animationLength, Array<TextureRegion> loadingTextureRegion){
        return  new Animation(animationLength, loadingTextureRegion);
    }

    public static TextureRegion getTextureRegion(IntroSpriteFrame aSprite, Texture spriteTexture){
        return new TextureRegion(spriteTexture, aSprite.getSpriteStartXPosition(),
                aSprite.getSpriteStartYPosition(), aSprite.getSpriteWidth(), aSprite.getSpriteWidth());
    }

    public static  Array<TextureRegion> getArray(){
        return new Array<>();
    }



}
