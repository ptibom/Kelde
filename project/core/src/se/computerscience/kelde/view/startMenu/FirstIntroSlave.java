package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.view.ui.Dialog;

/**
 * Created by Daniel on 5/20/2015.
 */
public class FirstIntroSlave {

    AnimationHandler animationHandlerWizard1;
    Texture background;
    Texture foreground;
    Texture border;
    DialogueHandler dialogueHandler;


public FirstIntroSlave(DialogueHandler dialogueHandler, AnimationHandler animationHandlerWizard, Texture texture1, Texture texture2,
                       Texture texture3){

    this.animationHandlerWizard1 = animationHandlerWizard;
    this.background = texture1;
    this.foreground = texture2;
    this.border = texture3;
    this.dialogueHandler = dialogueHandler;


}


    public void draw(SpriteBatch batch){


        // First draw the background texture
        batch.draw(background, 0, 0);


        //Dialogerna kommer renderas in och stanna där tills tiden gått till 50
        dialogueHandler.drawDialogue(0,batch, 8,50);

        dialogueHandler.drawDialogue(1,batch, 12,50);

        dialogueHandler.drawDialogue(2,batch, 16,50);

        dialogueHandler.drawDialogue(3,batch, 20,50);

        dialogueHandler.drawDialogue(4,batch, 24,50);

        dialogueHandler.drawDialogue(5,batch, 28,50);

        dialogueHandler.drawDialogue(6,batch, 32,50);

        dialogueHandler.drawDialogue(7,batch, 36,50);

        // Trollkarlen som går och gör saker
        animationHandlerWizard1.drawAnimation(batch,0, 2,4, 0, 0,0,0, "walkforward");
        animationHandlerWizard1.drawAnimation(batch,2, 6, 30, 30, -120,-40, "walkforward");
        animationHandlerWizard1.drawAnimation(batch,6,8,4, 0, 0,0,0, "walkforward");
        animationHandlerWizard1.drawAnimation(batch,8,40, 0, 0,0,0, "wandlight");
        animationHandlerWizard1.drawAnimation(batch,40,43,4, 0, 0,0,0, "walkforward");
        animationHandlerWizard1.drawAnimation(batch,43,50, -15, -15,60,20, "backwalk");

        // Allting som är längst fram
        batch.draw(foreground, 0, 0);
        batch.draw(border, 0, 0);





    }

}
