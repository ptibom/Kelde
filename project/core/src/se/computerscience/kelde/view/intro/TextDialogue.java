package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.intro.Intro;

/**
 * @author: Daniel Olsson
 */
public class TextDialogue {

    private double scale = 0.5;
    private Texture dialogueTexture;
    private TextureRegion textRegion;
    private double percentToShow;
    private static final int OFFSET_FROM_SCREEN = 50;
    private static final int SCREEN_HEIGHT = 1080;
    private static final int SCREEN_WIDTH = 1920;
    private static final int TEXT_MOVEMENT_SPEED = 384;
    private  final double timeLengthToShow;

    public TextDialogue(Texture dialogueTexture, double timeLengthToShow) {
        this.dialogueTexture = dialogueTexture;
        percentToShow = 0;
        this.timeLengthToShow = timeLengthToShow;

    }


    public TextureRegion updateTextureRegion(Intro introModel, float delta) {

        if (percentToShow + OFFSET_FROM_SCREEN == SCREEN_WIDTH) {
            percentToShow = SCREEN_WIDTH;
        } else
            percentToShow += SCREEN_WIDTH * TEXT_MOVEMENT_SPEED;


        textRegion = new TextureRegion(dialogueTexture, (int) ((OFFSET_FROM_SCREEN + percentToShow)*scale), (int)(SCREEN_HEIGHT*scale));

        return textRegion;

    }

    public double getTimeToLast(){
        return timeLengthToShow;
    }



}
