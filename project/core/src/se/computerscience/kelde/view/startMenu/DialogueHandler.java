package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.startmenu.StartMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 5/20/2015.
 */
public class DialogueHandler {
    StartMenu startMenuModel;
    List<TextDialogue> introTextTextDialogues;

    private final Texture[] dialogueImages = new Texture[30];
    private final String[] dialogues;

    public DialogueHandler(StartMenu startMenuModel){
        this.startMenuModel = startMenuModel;
        introTextTextDialogues = new ArrayList<TextDialogue>();
        String[] introTexts = startMenuModel.getIntroTextImages();

        for(int i = 0; i< introTexts.length; i++) {

            introTextTextDialogues.add(new TextDialogue(new Texture(introTexts[i])));

        }


        dialogues = startMenuModel.getDialogues();


        for (int i = 0; i<dialogues.length; i++){

            dialogueImages[i] = new Texture(dialogues[i]);

        }



    }

    public  void drawDialogue(int dialoguenumber,SpriteBatch batch, double startTime, double endTime){

        // Here we send take the dialogue number and render it according to start and end time
        // A text-dialogue is always rendereder as large as the screen is

        if(AnimationTools.timeRange(startMenuModel.getMenuTime(), startTime,endTime)){

            TextDialogue d = introTextTextDialogues.get(dialoguenumber);
            TextureRegion regionToRender = d.updateTextureRegion(startMenuModel);
            batch.draw(regionToRender,0,0);


        }
    }

    public void drawChatDialogue(SpriteBatch batch, int dialogueNumber, double startTime, double endTime){


        if(AnimationTools.timeRange(startMenuModel.getMenuTime(), startTime,endTime)) {

            batch.draw(dialogueImages[dialogueNumber], 0, 0);
        }
    }




}
