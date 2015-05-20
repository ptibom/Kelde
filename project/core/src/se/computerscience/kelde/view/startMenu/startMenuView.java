package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.graphics.g2d.Animation;
import se.computerscience.kelde.model.startmenu.AnimationLoader;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.MenuButton;
import se.computerscience.kelde.view.intro.IntroView;


import java.util.*;


/**
 * @author: Daniel Olsson
 */
public class StartMenuView {


    Stage menuStage;
    List<Animation> allWalkingAnimations;
    float stateTime, introStateTime;

    Sprite fadeScreenSprite;
    Sound backgroundSound;

    MenuButton newGameButton, loadGameButton;
    int result;
    double startTime;
    double internalTimerFadeOut = 0;
    double internalTimerFadeIn = 0;
    double introPassedTime;
    boolean startIntro = false;
    private StartMenu startMenuModel;
    private SpriteBatch batch = new SpriteBatch();
    private OrthographicCamera cam2d;
    private boolean introStarted = false;


    MenuAnimationHandler menuAnimationHandler;
    AnimationLoader animationLoader;
    Texture backgroundTexture, foregroundTexture;


    public StartMenuView(StartMenu startMenuModel) {
        backgroundTexture = new Texture(startMenuModel.getBackground());
        foregroundTexture = new Texture(startMenuModel.getForegorund());

        this.startMenuModel = startMenuModel;
        cam2d = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        allWalkingAnimations = new ArrayList<Animation>();
        loadGameButton = new MenuButton(new Texture(startMenuModel.getBackground()), 750, 400,418,103);
        fadeScreenSprite = new Sprite( new Texture(startMenuModel.getFadeScreen()));
        initIntro();
        animationLoader = new AnimationLoader(startMenuModel);

        menuStage = new Stage();


    }

    public int renderMenu(){
        if(result<=0 && !introStarted) {
            renderStartMenu();
        }
        else {
            introStarted = true;
            backgroundSound.dispose();

            if (!startIntro) {
                startIntro = true;
            }

            startMenuModel.updateTimer();
            startMenuModel.updateStateTime();

            if (Gdx.input.isTouched()) {


                return 1;


            }
        }
        return 0;
    }


    public void renderStartMenu() {
        stateTime += Gdx.graphics.getDeltaTime();
        startMenuModel.updateStateTime();

        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(backgroundTexture, 0, 0);
        menuAnimationHandler.drawMenuAnimations(batch);
        batch.draw(foregroundTexture, 0, 0);
        batch.end();

        result = loadGameButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY(), Gdx.input.isTouched());

       // if(!(result == 0)){

    }

    public void init() {

        menuAnimationHandler = new MenuAnimationHandler(startMenuModel, animationLoader);
        backgroundSound= Gdx.audio.newSound(new FileHandle(startMenuModel.getBackgroundSoundPath()));

        stateTime=0f;
        backgroundSound.loop();

    }

    public void initIntro(){



    introStateTime = 0f;
        introPassedTime = -1f;

    }
        public void renderIntro(){

            stateTime += Gdx.graphics.getDeltaTime();
            GL20 gl = Gdx.graphics.getGL20();
            gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();


            batch.end();

    }



    public void fadeInScreen() {

        double timeLapse = (System.currentTimeMillis() - internalTimerFadeIn) /1000;


        if (timeLapse < 1) {

            fadeScreenSprite.setAlpha((float) timeLapse);
            fadeScreenSprite.draw(batch);

        }

    }

        public void fadeOutScreen(){

            double timeLapse = (System.currentTimeMillis() - internalTimerFadeOut) /1000;

            if ( timeLapse < 1) {

                fadeScreenSprite.setAlpha(1-(float)timeLapse);
                fadeScreenSprite.draw(batch);

            }
        }

    public Button[] getButton(){
        return new Button[]{newGameButton, loadGameButton};
     }


}


