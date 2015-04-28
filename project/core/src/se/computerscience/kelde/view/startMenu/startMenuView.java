package se.computerscience.kelde.view.startMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.startmenu.StartMenu;

/**
 * Created by MonoMan on 4/28/2015.
 */
public class StartMenuView {

    private StartMenu startMenuModel;
    private SpriteBatch batcher = new SpriteBatch();
    private OrthographicCamera cam2d;
    private int currentFrame = 5;



    public StartMenuView(StartMenu startMenuModel){

        this.startMenuModel = startMenuModel;
       // cam2d = new OrthographicCamera(1.0f,Gdx.graphics.getHeight()/Gdx.graphics.getWidth());
        cam2d = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    public void renderStartMenu() {
        Texture backgroundTexture = new Texture(startMenuModel.getBackground());
        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    //    batcher.setProjectionMatrix(cam2d.combined);
        batcher.begin();
        batcher.draw(backgroundTexture, -(Gdx.graphics.getWidth()/2), -(Gdx.graphics.getHeight()/2));
        batcher.end();
        batcher.begin();
        startMenuModel.get64x64sprites().get(currentFrame).draw(batcher);
        batcher.end();

        batcher.setProjectionMatrix(cam2d.combined);
        batcher.begin();
        startMenuModel.get128x128sprites().get(currentFrame).draw(batcher);
        batcher.end();

    }


}


