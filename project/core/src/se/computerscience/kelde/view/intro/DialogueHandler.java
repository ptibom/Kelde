package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.intro.AnimationToolsUtilites;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.model.intro.Timer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

// Handles all the kind of dialogues in the intro, from the text at the start and
// the speech bubbles later.
public class DialogueHandler {
    private final double introDelay;
    private final Intro introModel;
    private final List<TextDialogue> introTextTextDialogues;
    private final Texture[] dialogueImages = new Texture[30];
    private final Timer t;
    private  TextureRegion regionToRender;

    public DialogueHandler(Intro introModel, double introDelay) {
        t = new Timer();
        t.resetTimer();
        this.introModel = introModel;
        introTextTextDialogues = new ArrayList<>();


        // Here we load in the dialogues and the text file paths from the model.
        final String[] dialogues = introModel.getDialogues();
        final String[] introTexts = introModel.getIntroTextImages();


        // This is the delay for the intro, part2 starts later and everything is
        // then counted from 0.
        this.introDelay = introDelay;

        // Here we add the dialogues and texts to an array, to ease of use.
        for (int i = 0; i < introTexts.length; i++) {
            introTextTextDialogues.add(createTextDialogue(introTexts[i], i * 2000 + 9000));
        }

        for (int i = 0; i < dialogues.length; i++) {
            dialogueImages[i] = createNewTexture(dialogues[i]);
        }
    }

    public void drawTextDialogue(int dialoguenumber, SpriteBatch batch, double startTime, double endTime, float delta, double scale) {

        // Here we send take the dialogue number and render it according to start and end time
        // A text-dialogue is always render as large as the screen is

        if (AnimationToolsUtilites.timeRange(introModel.getMenuTime(), startTime, endTime)) {


            regionToRender=getTextureRegion(dialoguenumber, delta);
            t.updateTimer();
            if(introTextTextDialogues.get(dialoguenumber).getTimeToLast()+startTime*1000>t.getMenuTime()) {
                batch.draw(regionToRender, 0, 260, (int) (regionToRender.getRegionWidth() * scale), (int) (regionToRender.getRegionHeight() * scale));
            }

        }
    }


    public void drawChatDialogue(SpriteBatch batch, int dialogueNumber, double startTime, double endTime, double scale) {


        if (AnimationToolsUtilites.timeRange(introModel.getMenuTime(), startTime + introDelay, endTime + introDelay)) {
            batch.draw(dialogueImages[dialogueNumber], 0, 0, (int) (dialogueImages[dialogueNumber].getWidth() * scale),
                    (int) (dialogueImages[dialogueNumber].getHeight() * scale));
        }
    }


    public Texture createNewTexture(String textPath){
        return new Texture(textPath);

    }

    public TextDialogue createTextDialogue(String textPath, int i){

        return new TextDialogue(createNewTexture(textPath), i);
    }

    public TextureRegion getTextureRegion( int dialogueNumber, float delta){
        return introTextTextDialogues.get(dialogueNumber).updateTextureRegion();
    }

}
