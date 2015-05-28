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
import se.computerscience.kelde.model.startmenu.StartMenu;

/**
 * @author: Daniel Olsson
 */
public class StartMenuView {


    private static final int ORIGINAL_SCREEN_WIDTH = 1920;
    private static final int ORIGINAL_SCREEN_HEIGHT = 1080;
    private final Stage menuStage;
    private final Music backgroundMusic;
    private final StartMenu startMenuModel;
    private final SpriteBatch batch;
    private final  TextButton newGameButton, loadGameButton, exitbutton;
    private final MenuAnimationHandler menuAnimationHandler;
    private final Texture backgroundTexture, foregroundTexture, middleGroundTexture;

    private final  Viewport viewport;

    public StartMenuView(StartMenu startMenuModel) {

        // Loads the batch that draws everything
        batch = new SpriteBatch();

        // Creating a stage to put actors in and a view port
        menuStage = new Stage();

        viewport = new FitViewport(ORIGINAL_SCREEN_WIDTH, ORIGINAL_SCREEN_HEIGHT, menuStage.getCamera());
        Gdx.input.setInputProcessor(menuStage);
        middleGroundTexture = new Texture(startMenuModel.getMidGround());


        //Initializing buttons

        // Creates skins for buttons and creates textButtons with them
        final  Skin skin = createSkin("menu/startbutton.png");
        final Skin skin2 = createSkin("menu/loadbutton.png");
        final Skin skin3 = createSkin("menu/exitbutton.png");


        loadGameButton = new TextButton("", skin2);
        newGameButton = new TextButton("", skin);
        exitbutton = new TextButton("", skin3);

        //Initializes their positions and adds them to the stage
        final int LOAD_BUTTON_POS_X = 730;
        final int LOAD_BUTTON_POS_Y = 373;
        final int START_BUTTON_POS_X = 730;
        final int START_BUTTON_POS_Y = 550;
        final int EXIT_BUTTON_POS_X = 1140;
        final int EXIT_BUTTON_POS_Y = 370;

        newGameButton.setPosition(START_BUTTON_POS_X, START_BUTTON_POS_Y);
        loadGameButton.setPosition(LOAD_BUTTON_POS_X, LOAD_BUTTON_POS_Y);
        exitbutton.setPosition(EXIT_BUTTON_POS_X, EXIT_BUTTON_POS_Y);



        menuStage.setViewport(viewport);

        // Loads other assets as textures and music

        backgroundTexture = new Texture(startMenuModel.getBackground());
        foregroundTexture = new Texture(startMenuModel.getForeground());
        backgroundMusic = Gdx.audio.newMusic(new FileHandle(startMenuModel.getBackgroundSoundPath()));

        //Creates an animationloader that loads all animations, using data from the model;
        this.startMenuModel = startMenuModel;
        menuAnimationHandler = new MenuAnimationHandler(startMenuModel);
        backgroundMusic.play();

    }


    public int renderMenu(float delta) {

        //Updates delta-value so that we get
        startMenuModel.updateStateTime(delta);


        // This is the draw part, draws background, characters, then foreground.
        batch.begin();
        batch.draw(backgroundTexture, 0, 0, 960, 540);


        batch.end();


        //Makes sure the stage records all input
        menuStage.act();
        menuStage.draw();


        batch.begin();

        batch.draw(middleGroundTexture,0, 0,960,540);
        menuAnimationHandler.drawMenuAnimations(batch);

        batch.draw(foregroundTexture,0, 0,960,540);
        batch.end();

        if(exitbutton.isPressed()){
            Gdx.app.exit();
        }

        return 0;
    }


    // Need to resize, incase user resizes screen
    public void resize(int width, int height) {
        menuStage.getCamera().position.x = width;
        viewport.update(width, height, true);

    }



    // Creates and returns a Skin using image from file path
    public Skin createSkin(String imageFilePath) {
        final Skin skin = new Skin();
        final BitmapFont font = new BitmapFont();
        final String bak = "background";
        skin.add("default", font);

        final Pixmap pixmap = new Pixmap((int) Gdx.graphics.getWidth() / 4, (int) Gdx.graphics.getHeight() / 10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add(bak, new Texture(imageFilePath));

        final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable(bak, Color.RED);
        textButtonStyle.down = skin.newDrawable(bak, Color.GREEN);
        textButtonStyle.checked = skin.newDrawable(bak, Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable(bak, Color.BLUE);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);

        return skin;
    }

    public TextButton getButton() {
        return newGameButton;
    }

    public TextButton getLoadButton() {
        return loadGameButton;
    }

    public void addActors() {

        // Adding the buttons as actor in stage
        menuStage.addActor(newGameButton);
        menuStage.addActor(loadGameButton);
        menuStage.addActor(exitbutton);
    }

    public void stopMusic(){
        backgroundMusic.stop();
    }


}
