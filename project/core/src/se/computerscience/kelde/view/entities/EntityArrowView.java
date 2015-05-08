package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import se.computerscience.kelde.model.Heading;

/**
 * Created by Anders on 2015-05-08.
 */
public class EntityArrowView {

    //Variables
    private Texture texture;
    private final int WIDTH = 32, HEIGHT = 32;
    private Texture arrowNorth, arrowEast, arrowSouth, arrowWest;
    private Heading direction;
    private float x,y, elapsed_time;
    private int positionY;

    /**
     * Constructor
     */
    public EntityArrowView(Heading direction, float x, float y) {
        this.x = x;
        this.y = y;
        elapsed_time = 0;
        arrowNorth = new Texture("arrownorth.png");
        arrowEast = new Texture("arroweast.png");
        arrowSouth = new Texture("arrowsouth.png");
        arrowWest = new Texture("arrowwest.png");
        this.direction = direction;
    }

    public void draw(Batch batch){
        if(direction == Heading.NORTH) {
            texture = arrowNorth;
        } else if(direction == Heading.EAST) {
            texture = arrowEast;
        } else if(direction == Heading.SOUTH) {
            texture = arrowSouth;
        } else if(direction == Heading.WEST) {
            texture = arrowWest;
        }
        batch.draw(texture, x, y);
    }

    public void update(float delta) {
        elapsed_time += delta;
        travelledDistance();
    }

    private void travelledDistance() {
        if(direction == Heading.NORTH) {
            y += 5;
        } else if(direction == Heading.WEST) {
            x -= 5;
        } else if(direction == Heading.SOUTH) {
            y -= 5;
        } else if(direction == Heading.EAST) {
            x += 5;
        }
    }

    public float getPositionY() {
        return y;
    }

    public float getPositionX() {
        return x;
    }
}
