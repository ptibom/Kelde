package se.computerscience.kelde.model.startmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.List;

/**
 * Created by MonoMan on 4/27/2015.
 */
public class StartMenu {

   private static final String BACKGROUND = "StartMenuBackground.png";
   private static final String FOREGROUND = "StartMenuForeground.png";
    TextureAtlas spriteSheet64 = new TextureAtlas("MenuSpriteSheet64.txt");
    TextureAtlas spriteSheet128 = new TextureAtlas("MenuSpriteSheet128.txt");
    private Array<Sprite> skeleton64 = spriteSheet64.createSprites();
    private Array<Sprite> skeleton128 = spriteSheet128.createSprites();


    public StartMenu(){

        for(int i=0; i<skeleton64.size; i++){
            skeleton64.get(i).setSize(64.0f, 64.0f);
        }

        for(int i=0; i<skeleton128.size; i++){
            skeleton128.get(i).setSize(128.0f, 128.0f);
        }


    }

    public Array<Sprite> get64x64sprites(){

        return skeleton64;

    }

    public Array<Sprite> get128x128sprites(){

        return skeleton128;

    }

    public String getBackground(){

        return BACKGROUND;
    }

    public String getForegorund(){

        return FOREGROUND;
    }
}
