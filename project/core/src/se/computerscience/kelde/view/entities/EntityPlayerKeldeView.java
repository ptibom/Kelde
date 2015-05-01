/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;

public class EntityPlayerKeldeView {
    private final EntityPlayerKelde entityPlayerKelde;
    private final Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 48;
    private final String SPRITE_LOCATION = "testSprite.png";

    public EntityPlayerKeldeView(EntityPlayerKelde entityPlayerKelde) {
        this.entityPlayerKelde = entityPlayerKelde;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }

    public void draw (SpriteBatch batch) {
        sprite.setPosition(entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        sprite.draw(batch);
    }
}
