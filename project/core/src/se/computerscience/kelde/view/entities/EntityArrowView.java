package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.entities.EntityArrow;

/**
 * Created by Anders on 2015-05-08.
 * @author Anders Bolin
 */
public class EntityArrowView {

    //Variables
    private final EntityArrow entityArrow;

    private Texture texture;
    private Texture arrowNorth, arrowEast, arrowSouth, arrowWest;
    private float elapsed_time;

    /**
     * Constructor
     */
    public EntityArrowView(EntityArrow entityArrow) {
        this.entityArrow = entityArrow;
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

    public void setArrowStart(int x, int y) {
        entityArrow.setPosition(x,y);
    }
}
