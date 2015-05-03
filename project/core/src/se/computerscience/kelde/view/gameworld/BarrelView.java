package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Hassan on 2015-04-21.
 */
public class BarrelView extends WorldObjectsView {

    private SpriteBatch batch;
    public BarrelView(int x, int y, boolean isMoveable) {
        //super(isMoveable, x, y);
        batch = new SpriteBatch();
        //super.settexture(new Texture("barrel.png"));
    }


    public void initWorld() {
        //super.initWorld();
        setSpriteSizeX(32);
        setSpriteSizeY(50);
    }


    public void resize(int width, int height, OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render() {
        super.render();

        batch.begin();
        //super.getObjSprite().draw(batch);
        batch.end();
    }
}
