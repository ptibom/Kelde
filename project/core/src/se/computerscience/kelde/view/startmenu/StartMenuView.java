package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import se.computerscience.kelde.events.ScreenEvent;
import se.computerscience.kelde.events.ScreenEventBus;
import se.computerscience.kelde.model.startmenu.AnimationLoader;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.startmenu.MenuAnimationHandler;

/**
 * @author: Daniel Olsson
 */
public class StartMenuView {

    private final int ORIGINAL_SCREEN_WIDTH = 1920;
    private final int ORIGINAL_SCREEN_HEIGHT = 1080;
    private final Stage menuStage;
    private final Music backgroundMusic;
    private final StartMenu startMenuModel;
    private SpriteBatch batch;
    private final Skin skin, skin2, skin3;
    private final TextButton newGameButton, loadGameButton, exitbutton;
    private final MenuAnimationHandler menuAnimationHandler;
    private final AnimationLoader animationLoader;
    private final Texture backgroundTexture, foregroundTexture;

    private Viewport viewport;

    public StartMenuView(StartMenu startMenuModel) {

        // Loads the batch that draws everything
        batch = new SpriteBatch();

        // Creating a stage to put actors in and a view port
        menuStage = new Stage();
        viewport = new FitViewport(ORIGINAL_SCREEN_WIDTH, ORIGINAL_SCREEN_HEIGHT, menuStage.getCamera());

        // Creates skins for buttons and creates textButtons with them
        skin = createSkin( "menu/startbutton.png");
        skin2 =   createSkin( "menu/loadbutton.png");
        skin3 = createSkin("menu/exitbutton.png");
        Gdx.input.setInputProcessor(menuStage);

        loadGameButton = new TextButton("", skin2);
        newGameButton = new TextButton("", skin);
        exitbutton = new TextButton("", skin3);

        //Initializes their positions and adds them to the stage
        int LOAD_BUTTON_POS_X = 780, LOAD_BUTTON_POS_Y = 473, START_BUTTON_POS_X = 780,
                START_BUTTON_POS_Y = 350 ,EXIT_BUTTON_POS_X = 1085,EXIT_BUTTON_POS_Y = 343;

        newGameButton.setPosition(LOAD_BUTTON_POS_X,LOAD_BUTTON_POS_Y);
        loadGameButton.setPosition(START_BUTTON_POS_X,START_BUTTON_POS_Y);
        exitbutton.setPosition(EXIT_BUTTON_POS_X,EXIT_BUTTON_POS_Y);
        menuStage.addActor(newGameButton);
        menuStage.addActor(loadGameButton);
        menuStage.addActor(exitbutton);

        // Loads other assets as textures and music
        backgroundTexture = new Texture(startMenuModel.getBackground());
        foregroundTexture = new Texture(startMenuModel.getForegorund());
        backgroundMusic = Gdx.audio.newMusic(new FileHandle(startMenuModel.getBackgroundSoundPath()));

        //Creates an animationloader that loads all animations, using data from the model;
        this.startMenuModel = startMenuModel;
        animationLoader = new AnimationLoader(startMenuModel);
        menuAnimationHandler = new MenuAnimationHandler(startMenuModel, animationLoader);
        backgroundMusic.play();
    }


    public int renderMenu(float delta) {

        //Updates delta-value so that we get
        startMenuModel.updateStateTime(delta);


        // This is the draw part, draws background, characters, then foreground.
        batch.begin();
        batch.draw(backgroundTexture, 0, 0);
        menuAnimationHandler.drawMenuAnimations(batch);
        batch.draw(foregroundTexture, 0, 0);
        batch.end();


        //Checking for button presses
        if(newGameButton.isPressed()){
            backgroundMusic.stop();
            ScreenEventBus.INSTANCE.publish(new ScreenEvent(ScreenEvent.Tag.SET_SCREEN, ScreenEvent.ScreenTag.START_INTRO));
        }

        if (loadGameButton.isPressed()) {


        }


        //Makes sure the stage records all input
        menuStage.act();
        menuStage.draw();

        return 0;
    }


    // Need to resize, incase user resizes screen
    public void resize(int width, int height) {
        viewport.update(width, height);
        menuStage.setViewport(viewport);
    }


    // Creates and returns a Skin using image from file path
    public Skin createSkin( String imageFilePath) {
        Skin skin = new Skin();
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        Pixmap pixmap = new Pixmap((int) Gdx.graphics.getWidth() / 4, (int) Gdx.graphics.getHeight() / 10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("background", new Texture(imageFilePath));

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.RED);
        textButtonStyle.down = skin.newDrawable("background", Color.GREEN);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.BLUE);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);

        return skin;
    }



}
