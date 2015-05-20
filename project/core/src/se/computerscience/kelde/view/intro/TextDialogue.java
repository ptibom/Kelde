package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.model.startmenu.StartMenu;

/**
 * @author: Daniel Olsson
 */
public class TextDialogue {
    private double startTime, endTime;
    private Texture dialogueTexture;
    private TextureRegion textRegion;
    private double percentToShow;


    public TextDialogue(Texture dialogueTexture){
        this.dialogueTexture = dialogueTexture;
        percentToShow = 0;
    }


    public TextureRegion updateTextureRegion(Intro introModel){

        if(percentToShow + 50 == 1920){
            percentToShow = 1920;
        }
        else
        percentToShow += introModel.getDeltaTime()*384;


        textRegion =  new TextureRegion(dialogueTexture,(int)(50+percentToShow),1080);

        return textRegion;

    }



}
