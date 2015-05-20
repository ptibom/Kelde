package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import se.computerscience.kelde.model.startmenu.AnimationLoader;
import se.computerscience.kelde.model.startmenu.StartMenu;


/**
 * @author: Daniel Olsson
 */
public class StartMenuView {


    private final Sprite fadeScreenSprite;
    private final Music backgroundMusic;
    //MenuButton newGameButton,
    private final MenuButton loadGameButton;
    private int result;
    boolean startIntro = false;
    private StartMenu startMenuModel;
    private SpriteBatch batch = new SpriteBatch();
    private OrthographicCamera cam2d;
    private boolean introStarted = false;

    private MenuAnimationHandler menuAnimationHandler;
    private AnimationLoader animationLoader;
    private Texture backgroundTexture, foregroundTexture;

    public StartMenuView(StartMenu startMenuModel) {
        backgroundTexture = new Texture(startMenuModel.getBackground());
        foregroundTexture = new Texture(startMenuModel.getForegorund());
        backgroundMusic = Gdx.audio.newMusic(new FileHandle(startMenuModel.getBackgroundSoundPath()));
        this.startMenuModel = startMenuModel;
        cam2d = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        loadGameButton = new MenuButton(new Texture(startMenuModel.getBackground()), 750, 400, 418, 103);
        fadeScreenSprite = new Sprite(new Texture(startMenuModel.getFadeScreen()));
        initIntro();
        animationLoader = new AnimationLoader(startMenuModel);


    }

    public int renderMenu(float delta) {
        if (result <= 0 && !introStarted) {

            startMenuModel.updateStateTime(delta);

            batch.begin();

            batch.draw(backgroundTexture, 0, 0);
            menuAnimationHandler.drawMenuAnimations(batch);
            batch.draw(foregroundTexture, 0, 0);
            batch.end();

            result = loadGameButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY(), Gdx.input.isTouched());
        } else {
            introStarted = true;
            backgroundMusic.dispose();

            if (!startIntro) {
                startIntro = true;
            }

            if (Gdx.input.isTouched()) {
                return 1;

            }
        }
        return 0;
    }


    public void init() {

        menuAnimationHandler = new MenuAnimationHandler(startMenuModel, animationLoader);

        backgroundMusic.play();

    }

    public void initIntro() {


    }


    /*
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
    */
    public Button[] getButton() {
        return new Button[]{loadGameButton};
    }


}


