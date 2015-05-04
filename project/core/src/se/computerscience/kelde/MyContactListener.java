package se.computerscience.kelde;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import se.computerscience.kelde.controller.gameworld.BarrelController;
import se.computerscience.kelde.controller.gameworld.GameWorldController;
import se.computerscience.kelde.controller.gameworld.IWorldObjectsController;
import se.computerscience.kelde.controller.gameworld.TreasureController;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.gameworld.BarrelModel;
import se.computerscience.kelde.model.gameworld.TreasureModell;

import java.util.Objects;

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
        if (isTreasure(contact) && worldObjects[1] instanceof TreasureController && isPlayer(contact))
            ((TreasureController)worldObjects[1]).openTreasure();

        if (isBarrel(contact) && worldObjects[0] instanceof BarrelController )
            System.out.println("just a barrel stop cry");
    }

    @Override
    public void endContact(Contact contact) {
        if (isTreasure(contact) && worldObjects[1] instanceof TreasureController)
            ((TreasureController)worldObjects[1]).closeTreasure();
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    public boolean isTreasure(Contact contact){
        return contact.getFixtureB().getUserData() instanceof TreasureModell;
    }
    public boolean isBarrel(Contact contact){
        return contact.getFixtureB().getUserData() instanceof BarrelModel;
    }

    public boolean isPlayer(Contact contact){
        return contact.getFixtureA().getUserData() instanceof EntityPlayerKelde;
    }
}
