package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import se.computerscience.kelde.model.startmenu.StartMenu;

/**
 * @author: Daniel Olsson
 */
public class StartMenuView {

    private static final int BACKGROUND_ORIGIN_SIZE_H = 540, BACKGROUND_ORIGIN_SIZE_W = 960;
    private static final int TABLE_ORIGIN_X = 1000, TABLE_ORIGIN_Y = 540;
    private static final int ORIGINAL_SCREEN_WIDTH = 1920;
    private static final int ORIGINAL_SCREEN_HEIGHT = 1080;
    private final Stage menuStage;
    private final Music backgroundMusic;
    private final StartMenu startMenuModel;
    private final SpriteBatch batch;
    private final MenuButton newGameButton, loadGameButton, exitbutton;
    private final MenuAnimationHandler menuAnimationHandler;
    private final Texture backgroundTexture, foregroundTexture, middleGroundTexture;

    private final Viewport viewport;

    public StartMenuView(StartMenu startMenuModel) {

        // Loads the batch that draws everything
        batch = new SpriteBatch();
        // Creating a stage to put actors in and a view port
        menuStage = new Stage();
        final Table table = new Table();
        final Table innerTable = new Table();
        viewport = new FitViewport(ORIGINAL_SCREEN_WIDTH, ORIGINAL_SCREEN_HEIGHT, menuStage.getCamera());
        Gdx.input.setInputProcessor(menuStage);
        middleGroundTexture = new Texture(startMenuModel.getMidGround());

        // Creating the menu buttons
        loadGameButton = new MenuButton(MenuButton.createSkin("menu/loadbutton.png"));
        newGameButton = new MenuButton(MenuButton.createSkin("menu/startbutton.png"));
        exitbutton = new MenuButton(MenuButton.createSkin("menu/exitbutton.png"));

        //Creating an inner table, to get the right spacing for load and new game button
        innerTable.add(newGameButton);
        innerTable.row();
        innerTable.add(loadGameButton);
        table.add(innerTable);
        // Adding the exit button at the right to the first table
        table.add(exitbutton);
        table.setPosition(TABLE_ORIGIN_X, TABLE_ORIGIN_Y);
        table.getPadBottom();
        menuStage.addActor(table);


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
        batch.draw(backgroundTexture, 0, 0, BACKGROUND_ORIGIN_SIZE_W, BACKGROUND_ORIGIN_SIZE_H);
        batch.end();

        //Makes sure the stage records all input
        menuStage.act();
        menuStage.draw();
        batch.begin();

        batch.draw(middleGroundTexture, 0, 0, BACKGROUND_ORIGIN_SIZE_W, BACKGROUND_ORIGIN_SIZE_H);
        menuAnimationHandler.drawMenuAnimations(batch);

        batch.draw(foregroundTexture, 0, 0, BACKGROUND_ORIGIN_SIZE_W, BACKGROUND_ORIGIN_SIZE_H);
        batch.end();

        if (exitbutton.isPressed()) {
            Gdx.app.exit();
        }

        return 0;
    }

    // Need to resize, in case user resizes screen
    public void resize(int width, int height) {
        menuStage.getCamera().position.x = width;
        viewport.update(width, height, true);

    }

    public TextButton getButton() {
        return newGameButton;
    }

    public TextButton getLoadButton() {
        return loadGameButton;
    }

    public void stopMusic() {
        backgroundMusic.stop();
    }

    public void dispose(){
        batch.dispose();
    }


}
