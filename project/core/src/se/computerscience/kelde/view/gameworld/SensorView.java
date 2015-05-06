package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.gameworld.SensorModel;

/**
 * Created by Hassan on 2015-05-05.
 */
public class SensorView implements IWorldObjectView {
    private final SensorModel sensorModel;
    private Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 32;
    private final String SPRITE_LOCATION = "sensor.png";
    public SensorView(SensorModel sensorModel) {
        this.sensorModel = sensorModel;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setPosition(sensorModel.getPositionX(), sensorModel.getPositionY());
        sprite.draw(batch);
    }
}
