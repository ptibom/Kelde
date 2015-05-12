package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodyStatic;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.model.items.Sword;

/**
 * Description: a model for a treasure!
 * @author: Hossein Hussain
 */

public class Treasure implements IWorldObjects {

    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 16;
    private boolean isOpen = false;
    private final int AXEPACK=1;
    private final int SWORDPACK=2;
    private final Sword sword; // set to final
    private final Axe axe;

    IPhysicalBody entityBody;

    public Treasure(IB2DWorld ib2DWorld, float x, float y, int packNumber) {
        entityBody = new PhysicalBodyStatic(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld, this);
            sword = new Sword(ib2DWorld,x+50,y);
            axe = new Axe(ib2DWorld,x+100,y);
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
    public void setVisble(){
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