package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by Hassan on 2015-04-21.
 */
public class BarrelView extends WorldObjectsView {
    private SpriteBatch batch;
    public BarrelView(Body objBody) {
        super(objBody);
        batch = new SpriteBatch();
        super.setTexture(new Texture("barrel.png"));
        super.setSpriteSizeX(32);
        super.setSpriteSizeY(50);
    }

    @Override
    public void render() {
        super.render();
        batch.begin();
        super.getObjSprite().draw(batch);
        batch.end();
    }
    @Override
    public void resize(int width, int height, OrthographicCamera camera) {
           batch.setProjectionMatrix(camera.combined);
    }
}
