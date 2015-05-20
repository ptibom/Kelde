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

    private Texture dialogueTexture;
    private TextureRegion textRegion;
    private double percentToShow;


    public TextDialogue(Texture dialogueTexture) {
        this.dialogueTexture = dialogueTexture;
        percentToShow = 0;
    }


    public TextureRegion updateTextureRegion(Intro introModel, float delta) {

        if (percentToShow + 50 == 1920) {
            percentToShow = 1920;
        } else
            percentToShow += delta * 384;


        textRegion = new TextureRegion(dialogueTexture, (int) (50 + percentToShow), 1080);

        return textRegion;

    }


}
