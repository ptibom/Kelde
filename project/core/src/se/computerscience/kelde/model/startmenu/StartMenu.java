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
    private static final String WALKING_CHARACTER_PATH_PICTURE = "walkingcharacters.png";
    private static final String WALKING_CHARACTER_PATH_DATA = "walkingcharacters.txt";
    private static final String BACKGROUND_SOUND = "dethrone.mp3";
   private static final String NEW_GAME_BUTTON_PATH_PICTURE = "loadbutton.png";
    private static final String LOAD_GAME_BUTTON_PATH_PICTURE ="newgamebutton.png";
    private static final String DEMON_STATUES_PATH_PICTURE = "demonsbackground.png";

    public StartMenu(){




    }

    public String getNewGameButtonPathPicture(){

    return NEW_GAME_BUTTON_PATH_PICTURE;

    }

    public String getDemonBackgroundPathPicture(){

        return DEMON_STATUES_PATH_PICTURE;
    }

    public String getLoadGameButtonPathPicture(){
        return LOAD_GAME_BUTTON_PATH_PICTURE;
    }

    public String getWalkingCharacterPathPicture(){

        return WALKING_CHARACTER_PATH_PICTURE;

    }
    public String getWalkingCharacterPathData(){

        return WALKING_CHARACTER_PATH_DATA;

    }

    public String getBackgroundSoundPath(){
        return BACKGROUND_SOUND;
    }
    public String getBackground(){

        return BACKGROUND;
    }

    public String getForegorund(){

        return FOREGROUND;
    }
}
