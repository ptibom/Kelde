package se.computerscience.kelde;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import se.computerscience.kelde.controller.gameworld.IWorldObjectsController;
import se.computerscience.kelde.controller.gameworld.TreasureController;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;

/**
 * Created by Hossein on 2015-05-03.
 */
public class MyContactListener implements ContactListener {

    IWorldObjectsController[] worldObjects;

    public MyContactListener(IWorldObjectsController[] worldObjects) {
        this.worldObjects = worldObjects;
    }

    @Override
    public void beginContact(Contact contact) {
        if (isObject("treasure 1",contact) && isPlayer(contact))
            ((TreasureController)worldObjects[1]).openTreasure();
        else if (isObject("treasure 2",contact) && isPlayer(contact))
            ((TreasureController)worldObjects[3]).openTreasure();
        else if (isObject("barrel 1",contact) && isPlayer(contact))
            System.out.println("just a barrel stop cry");
    }

    @Override
    public void endContact(Contact contact) {
        if (isObject("treasure 1",contact) && isPlayer(contact))
            ((TreasureController)worldObjects[1]).closeTreasure();
        else if (isObject("treasure 2",contact) && isPlayer(contact))
            ((TreasureController)worldObjects[3]).closeTreasure();
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
    //checking if the contacted is the input userdata
    public boolean isObject(String userdata, Contact contact){
        return contact.getFixtureB().getUserData().equals(userdata);
    }
    //checks if the players collided
    public boolean isPlayer(Contact contact){
        return contact.getFixtureA().getUserData() instanceof EntityPlayerKelde;
    }
}
