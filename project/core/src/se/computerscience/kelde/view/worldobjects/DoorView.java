/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.worldobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.worldobjects.Door;

public class DoorView implements IWorldObjectView {
    private final Door door;
    private final Sprite sprite;
    private final Texture texture;
    private final static int WIDTH = 32, HEIGHT = 48;
    private final static String SPRITE_LOCATION1 = "door1.png";
    private final static String SPRITE_LOCATION2 = "door2.png";

    // you can choose with door to display when init.
    public DoorView(Door door, String spriteName) {
        this.door = door;
        if ("door1".equals(spriteName)){
            texture = new Texture(SPRITE_LOCATION1);
        }else{
            texture = new Texture(SPRITE_LOCATION2);
        }
        sprite = new Sprite(texture, WIDTH, HEIGHT);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setPosition(door.getPositionX(), door.getPositionY());
        sprite.draw(batch);
    }
}