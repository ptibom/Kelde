package se.computerscience.kelde.model.intro;

import java.util.List;

/**
 * @author: Daniel Olsson
 */


// This class is to create a easy to use animation for all possible libraries
public class IntroAnimation {


    private final List<IntroSpriteFrame> framesOfAnimation;



    public IntroAnimation(List<IntroSpriteFrame> framesOfAnimation){

        this.framesOfAnimation = framesOfAnimation;

    }


    public List<IntroSpriteFrame> getIntroSpriteFrames(){
        return framesOfAnimation;
    }
}
