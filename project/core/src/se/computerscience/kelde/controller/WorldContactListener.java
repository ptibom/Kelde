/**
 * Description: ContactListener
 *
 * @author: Hossein Hussain
 */

package se.computerscience.kelde.controller;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.controller.items.AxeController;
import se.computerscience.kelde.controller.items.SwordController;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.worldobjects.Treasure;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.model.items.Sword;
import se.computerscience.kelde.model.worldobjects.Door;

import java.util.List;


public class WorldContactListener implements ContactListener {
    List<IWorldObjectsController> worldObjects;

    public WorldContactListener(List<IWorldObjectsController> worldObjects) {
        this.worldObjects = worldObjects;
    }

    @Override
    public void beginContact(Contact contact) {
        //*** contact listener for WorldObjects, sensors and items ***
        if (isWorldObject(contact, Door.class)) {
            System.out.println("kelde just pressed a sensor");
        }

        if (isWorldObject(contact, Treasure.class) && isPlayer(contact)) {
            ((Treasure) contact.getFixtureB().getUserData()).setIsOpen(true);
            if (!(((AxeController) worldObjects.get(4)).isPicked())) { // checks if the items is not already picked
                ((AxeController) worldObjects.get(4)).setVisble(true); // making a drop visble when player open treasure chest
            }
        }

        if (isWorldObject(contact, Axe.class)&& isPlayer(contact)) {
            // if the drop is visble and player colides with the drop,
            // the item disapears (won't respawn if opening treasure chest again)

            if (((AxeController) worldObjects.get(4)).isVisble()) {
                ((AxeController) worldObjects.get(4)).setPicked(true);
                ((AxeController) worldObjects.get(4)).setVisble(false);
                System.out.println("kelde just picked up the axe");
            }
        }

        if (isWorldObject(contact, Sword.class) && isPlayer(contact)) {
            // if the drop is visble and player colides with the drop,
            // the item disapears (won't respawn if opening treasure chest again)
            if (((SwordController) worldObjects.get(5)).isVisble()) {
                ((SwordController) worldObjects.get(5)).setPicked(true);
                ((SwordController) worldObjects.get(5)).setVisble(false);
                System.out.println("kelde just picked up the sword");
                // add code to put the axe in keldes inventory here
            }
        }
        //***END OF*** contact listener for WorldObjects and items***
    }

    @Override
    public void endContact(Contact contact) {
        if (isWorldObject(contact, Treasure.class)) {
            ((Treasure) contact.getFixtureB().getUserData()).setIsOpen(false);
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }

    //checks if the players collided
    public boolean isPlayer(Contact contact) {
        if (!isFixtrueNull(contact)){
            return (contact.getFixtureA().getUserData() instanceof EntityPlayerKelde
                    || contact.getFixtureB().getUserData() instanceof  EntityPlayerKelde);
        }else {
            return false;
        }

    }
    public boolean isWorldObject(Contact contact, Class object){
        if (!isFixtrueNull(contact)){
            return (contact.getFixtureA().getUserData().getClass().isAssignableFrom(object)
                    || contact.getFixtureB().getUserData().getClass().isAssignableFrom(object));
        }else {
            return false;
        }

    }
    public boolean isFixtrueNull(Contact contact){
        if (contact.getFixtureA().getUserData() == null || contact.getFixtureB() == null){
            return true;
        }else {
            return false;
        }
    }
}