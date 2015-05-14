package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import se.computerscience.kelde.model.Heading;
import se.computerscience.kelde.model.entities.EntityArrow;

/**
 * Created by Anders on 2015-05-08.
 * @author Anders Bolin
 */
public class EntityArrowView {

    //Variables
    private final EntityArrow entityArrow;

    private Texture texture;
    private final int WIDTH = 32, HEIGHT = 32;
    private Texture arrowNorth, arrowEast, arrowSouth, arrowWest;
    private float elapsed_time = 0;

    /**
     * Constructor
     */
    public EntityArrowView(EntityArrow entityArrow) {
        this.entityArrow = entityArrow;
        elapsed_time = 0;
        setTextures();
    }

    private void setTextures() {
        arrowNorth = new Texture("arrownorth.png");
        arrowEast = new Texture("arroweast.png");
        arrowSouth = new Texture("arrowsouth.png");
        arrowWest = new Texture("arrowwest.png");
    }

    public void draw(Batch batch){
        Heading direction = entityArrow.getHeading();
        if(direction == Heading.NORTH) {
            texture = arrowNorth;
        } else if(direction == Heading.EAST) {
            texture = arrowEast;
        } else if(direction == Heading.SOUTH) {
            texture = arrowSouth;
        } else if(direction == Heading.WEST) {
            texture = arrowWest;
        }
        batch.draw(texture, entityArrow.getPositionX(), entityArrow.getPositionY());
    }

    public void update(float delta) {
        elapsed_time += delta;
    }
}
