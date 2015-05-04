package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import se.computerscience.kelde.model.gameworld.BarrelModel;
import se.computerscience.kelde.model.gameworld.TreasureModell;

/**
 * Created by Hossein on 2015-04-28.
 */
public class TreasureView {
    private final TreasureModell treasureModell;
    private Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 32;
    private final String SPRITE_LOCATION = "chest2.png";

    public TreasureView(TreasureModell treasureModell) {
        this.treasureModell = treasureModell;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }

    public void draw (SpriteBatch batch) {
        sprite.setPosition(treasureModell.getPositionX(), treasureModell.getPositionY());
        sprite.draw(batch);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
