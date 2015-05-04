package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.gameworld.BarrelModel;

/**
 * Created by Hossein.
 */
public class BarrelView{
    private final BarrelModel barrelModel;
    private final Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 48;
    private final String SPRITE_LOCATION = "barrel.png";

    public BarrelView(BarrelModel barrelModel) {
        this.barrelModel = barrelModel;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }

    public void draw (SpriteBatch batch) {
        sprite.setPosition(barrelModel.getPositionX(), barrelModel.getPositionY());
        sprite.draw(batch);
    }

}
