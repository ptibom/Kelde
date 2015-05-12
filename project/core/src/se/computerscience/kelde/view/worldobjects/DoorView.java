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
    private Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 48;
    private final String SPRITE_LOCATION1 = "door1.png";
    private final String SPRITE_LOCATION2 = "door2.png";
    public DoorView(Door door, String spriteName) {
        this.door = door;
        if (spriteName.equals("door1")){
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