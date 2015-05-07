package se.computerscience.kelde.view.startMenu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.Animation;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.MenuButton;
import se.computerscience.kelde.view.screens.GameScreen;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.awt.event.InputEvent;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Daniel on 4/28/2015.
 */
public class StartMenuView {
    Game keldeGame;
    Stage menuStage;
    Texture walkingCharacterTexture;
    TextureAtlas walkingCharacterAtlas;
    Array<Sprite> walkingCharactersSprites;
    final int SPRITE_SHEET_SIZE = 42/3;
    List<Animation> allWalkingAnimations;
    TextureRegion currentFrame;
    float stateTime;
    float stateTimeDelta;
    boolean onlyDoOnce = true;
    int spreadsheetOffset = 138;
    int spriteSize = 136;
    Texture backgroundTexture, foregroundTexture;
    Sound backgroundSound;
    MenuButton newGameButton, loadGameButton;
    int result;

    private StartMenu startMenuModel;
    private SpriteBatch batch = new SpriteBatch();
    private OrthographicCamera cam2d;
    private final int[] orderOfCharacterWalk;


    public StartMenuView(StartMenu startMenuModel, Game g) {
        keldeGame = g;
        this.startMenuModel = startMenuModel;
        cam2d = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        allWalkingAnimations = new ArrayList<Animation>();
        orderOfCharacterWalk = createRandomArray();
        backgroundTexture = new Texture(startMenuModel.getBackground());
        foregroundTexture = new Texture(startMenuModel.getForegorund());
        loadGameButton = new MenuButton(new Texture(startMenuModel.getBackground()), 750, 400,418,103);
    }

    public void renderStartMenu() {
        stateTime += Gdx.graphics.getDeltaTime();

        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(backgroundTexture, 0, 0);
        renderWalkSequenceRight();
        batch.draw(foregroundTexture, 0, 0);
        batch.end();

        result = loadGameButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY(), Gdx.input.isTouched());

        if(!(result == 0)){

            if (result == 1) {
                backgroundSound.dispose();
                keldeGame.setScreen(new GameScreen());
            }

            if (result == 2) {
                backgroundSound.dispose();
                keldeGame.setScreen(new GameScreen());
            }

                if (result == 3){
                    Gdx.app.exit();
                }


            backgroundSound.dispose();;
            keldeGame.setScreen(new GameScreen());
        }

    }

    public void init() {

        backgroundSound= Gdx.audio.newSound(new FileHandle(startMenuModel.getBackgroundSoundPath()));

        walkingCharacterTexture = new Texture(startMenuModel.getWalkingCharacterPathPicture());


        for (int i = 0, x = 2, y = 2; i < SPRITE_SHEET_SIZE; i++) {
            TextureRegion[] tempAnimationRegions = new TextureRegion[3];
            if (x > 830) {
                x = 2;
                y += spreadsheetOffset;

            }
            tempAnimationRegions[0] = new TextureRegion(walkingCharacterTexture, x, y, spriteSize,spriteSize);

            x += spreadsheetOffset;

            if (x > 830) {
                x = 2;
                y += spreadsheetOffset;

            }
            tempAnimationRegions[1] =  new TextureRegion(walkingCharacterTexture, x, y, spriteSize,spriteSize);;

            x += spreadsheetOffset;

            if (x > 830) {
                x = 2;
                y += spreadsheetOffset;

            }
            tempAnimationRegions[2] =  new TextureRegion(walkingCharacterTexture, x, y, spriteSize,spriteSize);

            x += spreadsheetOffset;

            //Now that we have loaded an animation's textureRegions, we create an animation from it.
            // And then load it into our list of animations.
            allWalkingAnimations.add(new Animation(0.27f, tempAnimationRegions));


        }



        stateTime=0f;
        backgroundSound.loop();

    }

    public void renderAnimationByIndex(int x, int y, int i) {


        currentFrame = allWalkingAnimations.get(i).getKeyFrame(stateTime, true);
        batch.draw(currentFrame, x + (stateTime - stateTimeDelta) * 18, y);

    }

    public void renderWalkSequenceRight(){

        renderAnimationByIndex(-2400,130, orderOfCharacterWalk[0] );
        renderAnimationByIndex(-2100,130, orderOfCharacterWalk[1] );
        renderAnimationByIndex(-1800,130, orderOfCharacterWalk[2] );
        renderAnimationByIndex(-1500,130, orderOfCharacterWalk[3] );
        renderAnimationByIndex(-1200,130, orderOfCharacterWalk[4] );
        renderAnimationByIndex(-900,130, orderOfCharacterWalk[5] );
        renderAnimationByIndex(-600,130, orderOfCharacterWalk[6] );
        renderAnimationByIndex(-300,130, orderOfCharacterWalk[7] );
        renderAnimationByIndex(0,130, orderOfCharacterWalk[8] );
        renderAnimationByIndex(300,130, orderOfCharacterWalk[9] );
        renderAnimationByIndex(600,130, orderOfCharacterWalk[10] );
        renderAnimationByIndex(900,130, orderOfCharacterWalk[11] );
        renderAnimationByIndex(1200,130, orderOfCharacterWalk[12] );
        renderAnimationByIndex(1500,130, orderOfCharacterWalk[13] );

    }



    public int[] createRandomArray(){

        Random ran = new Random();
        int[] tempRandomArray = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int index = 0;

        while(index < 14){

        int tempRandomNr = ran.nextInt(14);

            if(!contains(tempRandomArray,tempRandomNr)){

                tempRandomArray[index] = tempRandomNr;
                index++;

            }

        }

        return tempRandomArray;



    }

    public boolean contains(final int[] array, final int key) {
        int[] tempCopyArray = new int[14];
        System.arraycopy(array,0,tempCopyArray,0,array.length);
        Arrays.sort(tempCopyArray);
        int i = 0;
        while(i < tempCopyArray.length){
            if(tempCopyArray[i] == key){
                return true;
            }
            i++;

        }
        return false;
    }


    public Button[] getButton(){
        return new Button[]{newGameButton, loadGameButton};
     }


}


