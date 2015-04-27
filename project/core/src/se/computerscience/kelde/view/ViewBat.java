package se.computerscience.kelde.view;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Anders on 2015-04-06.
 */
public class ViewBat {

    //Variables
    private SpriteBatch batch;
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasE, textureAtlasW;
    private Animation animationN, animationS, animationE, animationW;

    /**
     * Public constructor
     */
    public ViewBat() {
        batch = new SpriteBatch();
        textureAtlasNorth = new TextureAtlas(Gdx.files.internal("bat.atlas"));
        animationN = new Animation(0.15f, textureAtlasNorth.getRegions());

        //Bat facing south
        textureAtlasSouth = new TextureAtlas(Gdx.files.internal("batSouth.atlas"));
        animationS = new Animation(0.15f, textureAtlasSouth.getRegions());

        //Bat facing east
        textureAtlasE = new TextureAtlas(Gdx.files.internal("batEast.atlas"));
        animationE = new Animation(0.15f, textureAtlasE.getRegions());

        //Bat facing west
        textureAtlasW = new TextureAtlas(Gdx.files.internal("batWest.atlas"));
        animationW = new Animation(0.15f, textureAtlasW.getRegions());
    }

    /**
     * Getter to access spritebatch
     * @return
     */
    public SpriteBatch getBatch() {
        return batch;
    }

    /**
     * Getter to access TextureAtlas
     * @return
     */
    public TextureAtlas getTextureAtlas() {
        return textureAtlasNorth;
    }

    /**
     * Getter to access Animation
     * @return
     */
    public Animation getAnimationN() { return animationN; }

    public Animation getAnimationS() { return animationS; }

    public Animation getAnimationE() { return animationE; }

    public Animation getAnimationW() { return animationW; }

}
