package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.intro.AnimationLoader;
import se.computerscience.kelde.model.startmenu.StartMenu;

import java.util.List;

/**
 * Created by Daniel on 5/20/2015.
 */
public class MenuAnimationHandler {


    private final StartMenu startMenuModel;
    private SpriteBatch batch;
    private final AnimationLoader animationloader;
    private final List<Animation> allWalkingAnimations;
    private final int[] orderOfCharacterWalk;

  public  MenuAnimationHandler(StartMenu startMenuModel, AnimationLoader animationLoader){

    this.startMenuModel = startMenuModel;
      this.animationloader = animationLoader;
      allWalkingAnimations = animationloader.loadWalkingCharacters();
      orderOfCharacterWalk = startMenuModel.createRandomArray();
    }




public void drawMenuAnimations(SpriteBatch batch){

this.batch = batch;

    renderAnimationByIndex(allWalkingAnimations,-2400,130, orderOfCharacterWalk[0] );
    renderAnimationByIndex(allWalkingAnimations,-2100,130, orderOfCharacterWalk[1] );
    renderAnimationByIndex(allWalkingAnimations,-1800,130, orderOfCharacterWalk[2] );
    renderAnimationByIndex(allWalkingAnimations, -1500, 130, orderOfCharacterWalk[3]);
    renderAnimationByIndex(allWalkingAnimations, -1200, 130, orderOfCharacterWalk[4]);
    renderAnimationByIndex(allWalkingAnimations, -900, 130, orderOfCharacterWalk[5]);
    renderAnimationByIndex(allWalkingAnimations,-600,130, orderOfCharacterWalk[6] );
    renderAnimationByIndex(allWalkingAnimations,-300,130, orderOfCharacterWalk[7] );
    renderAnimationByIndex(allWalkingAnimations,0,130, orderOfCharacterWalk[8] );
    renderAnimationByIndex(allWalkingAnimations, 300, 130, orderOfCharacterWalk[9]);
    renderAnimationByIndex(allWalkingAnimations, 600, 130, orderOfCharacterWalk[10]);
    renderAnimationByIndex(allWalkingAnimations, 900, 130, orderOfCharacterWalk[11]);
    renderAnimationByIndex(allWalkingAnimations, 1200, 130, orderOfCharacterWalk[12]);
    renderAnimationByIndex(allWalkingAnimations, 1500, 130, orderOfCharacterWalk[13]);


}




    public void renderAnimationByIndex(List<Animation> theAnimation, int x, int y, int i) {

        TextureRegion currentFrame;
        currentFrame = theAnimation.get(i).getKeyFrame(startMenuModel.getStateTime(), true);
        this.batch.draw(currentFrame, x + (startMenuModel.getStateTime()) * 18, y);

    }

}
