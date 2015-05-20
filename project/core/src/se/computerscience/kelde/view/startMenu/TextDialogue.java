package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.startmenu.StartMenu;

/**
 * Created by Daniel on 5/20/2015.
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


    public TextureRegion updateTextureRegion(StartMenu startMenuModel){

        if(percentToShow + 50 == 1920){
            percentToShow = 1920;
        }
        else
        percentToShow += startMenuModel.getDeltaTime()*384;


        textRegion =  new TextureRegion(dialogueTexture,(int)(50+percentToShow),1080);

        return textRegion;

    }



}
