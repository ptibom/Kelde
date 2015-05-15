package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodyStatic;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.model.items.Sword;

import java.util.Random;

/**
 * Description: a model for a treasure!
 *
 * @author: Hossein Hussain
 */

public class Treasure implements IWorldObjects {

    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 16;
    private boolean isOpen = false;
    private final Sword sword; // set to final
    private final Axe axe;
    Random random = new Random();
    IPhysicalBody entityBody;

    public Treasure(IB2DWorld ib2DWorld, float x, float y) {
        entityBody = new PhysicalBodyStatic(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);       // init the drop inside the treasure
        sword = new Sword(ib2DWorld, x + (random.nextInt(50) + 10), y + (random.nextInt(100) + 20)); // makes an instance of sxe, in a random position
        axe = new Axe(ib2DWorld, x - (random.nextInt(50) + 10), y + (random.nextInt(100) + 20));     // makes an instance of axe, in a random position
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public float getPositionY() {
        return entityBody.getPositionY() - BODY_HEIGHT;
    }

    @Override
    public float getPositionX() {
        return entityBody.getPositionX() - BODY_WIDTH;
    }

    public void setVisble() {
        sword.setVisible(true);
        axe.setVisible(true);
    }

    public Sword getSword() {
        return sword;
    }

    public Axe getAxe() {
        return axe;
    }
}