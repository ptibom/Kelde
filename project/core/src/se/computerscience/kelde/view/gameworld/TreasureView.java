package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Hossein on 2015-04-28.
 */
public class TreasureView extends WorldObjectsView {
    private SpriteBatch batch;
    public TreasureView(Body objBody) {
        super(objBody);
        batch = new SpriteBatch();
        super.setTexture(new Texture("chest2.png"));
        super.setSpriteSizeX(32);
        super.setSpriteSizeY(32);
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
