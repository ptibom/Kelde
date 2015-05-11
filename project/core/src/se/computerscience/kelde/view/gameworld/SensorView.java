/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.gameworld.SensorModel;

public class SensorView implements IWorldObjectView {
    private final SensorModel sensorModel;
    private Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 32;
    private final int WIDTH_DOOR = 32, HEIGHT_DOOR = 48;
    private final String SPRITE_LOCATION1 = "door1.png";
    private final String SPRITE_LOCATION2 = "door2.png";
    private final String SPRITE_LOCATION3 = "sensor.png";
    public SensorView(SensorModel sensorModel, String spriteNr) {
        this.sensorModel = sensorModel;
        if (spriteNr.equals("door1"))
            texture = new Texture(SPRITE_LOCATION1);
        else if (spriteNr.equals("door2"))
            texture = new Texture(SPRITE_LOCATION2);
        else
            texture = new Texture(SPRITE_LOCATION3);

        if (spriteNr.equals("door1") || spriteNr.equals("door2"))
            sprite = new Sprite(texture, WIDTH_DOOR, HEIGHT_DOOR);
        else
            sprite = new Sprite(texture, WIDTH, HEIGHT);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setPosition(sensorModel.getPositionX(), sensorModel.getPositionY());
        sprite.draw(batch);
    }
}