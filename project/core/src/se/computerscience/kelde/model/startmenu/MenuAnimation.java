package se.computerscience.kelde.model.startmenu;

import java.util.List;

/**
 * @author: Daniel Olsson
 */


// This class is to create a easy to use animation for all possible libraries
public class MenuAnimation {


    private final List<MenuSprite> framesOfAnimation;



    public MenuAnimation(List<MenuSprite> framesOfAnimation){

        this.framesOfAnimation = framesOfAnimation;

    }


    public List<MenuSprite> getMenuSpriteFrames(){
        return framesOfAnimation;
    }
}
