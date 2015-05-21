package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.view.startmenu.AnimationTools;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

// Handles all the kind of dialogues in the intro, from the text at the start and
// the speech bubbles later.
public class DialogueHandler {
    private final double introDelay;
    private final Intro IntroModel;
    private final List<TextDialogue> introTextTextDialogues;
    private final Texture[] dialogueImages = new Texture[30];
    private final String[] dialogues;

    public DialogueHandler(Intro IntroModel, double introDelay) {

        this.IntroModel = IntroModel;
        introTextTextDialogues = new ArrayList<>();

        // Here we load in the dialogues and the text file paths from the model.
        dialogues = IntroModel.getDialogues();
        String[] introTexts = IntroModel.getIntroTextImages();


        // This is the delay for the intro, part2 starts later and everything is
        // then counted from 0.
        this.introDelay = introDelay;

        // Here we add the dialogues and texts to an array, to ease of use.
        for (int i = 0; i < introTexts.length; i++) {
            introTextTextDialogues.add(new TextDialogue(new Texture(introTexts[i])));
        }

        for (int i = 0; i < dialogues.length; i++) {
            dialogueImages[i] = new Texture(dialogues[i]);
        }
    }

    public void drawDialogue(int dialoguenumber, SpriteBatch batch, double startTime, double endTime, float delta) {

        // Here we send take the dialogue number and render it according to start and end time
        // A text-dialogue is always render as large as the screen is

        if (AnimationTools.timeRange(IntroModel.getMenuTime(), startTime, endTime)) {

            TextDialogue d = introTextTextDialogues.get(dialoguenumber);
            TextureRegion regionToRender = d.updateTextureRegion(IntroModel, delta);
            batch.draw(regionToRender, 0, 0);
        }
    }


    public void drawChatDialogue(SpriteBatch batch, int dialogueNumber, double startTime, double endTime) {


        if (AnimationTools.timeRange(IntroModel.getMenuTime(), startTime + introDelay, endTime + introDelay)) {
            batch.draw(dialogueImages[dialogueNumber], 0, 0);
        }
    }


}
