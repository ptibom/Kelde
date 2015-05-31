package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author: Daniel Olsson
 */
public class TextDialogue {

    final static private double SCALE = 0.5;
    final private Texture dialogueTexture;
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

    public TextureRegion updateTextureRegion() {
            percentToShow += SCREEN_WIDTH * TEXT_MOVEMENT_SPEED;

        return new TextureRegion(dialogueTexture, (int) ((OFFSET_FROM_SCREEN + percentToShow)*SCALE), (int)(SCREEN_HEIGHT*SCALE));
    }

    public double getTimeToLast(){
        return timeLengthToShow;
    }
}
