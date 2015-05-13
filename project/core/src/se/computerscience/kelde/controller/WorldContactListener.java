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
    @Override
    public void beginContact(Contact contact) {
        //*** contact listener for WorldObjects, sensors and items ***
        if (isWorldObject(contact, Door.class) && isPlayer(contact)) {
            System.out.println("kelde just pressed a sensor");
        }

        if (isWorldObject(contact, Treasure.class) && isPlayer(contact)) {
            if (isFixtureB(contact,Treasure.class)){
                ((Treasure) contact.getFixtureB().getUserData()).setIsOpen(true);
                ((Treasure) contact.getFixtureB().getUserData()).setVisble();
            }else {
                ((Treasure) contact.getFixtureA().getUserData()).setIsOpen(true);
                ((Treasure) contact.getFixtureA().getUserData()).setVisble();
            }


        }

        if (isWorldObject(contact, Axe.class)&& isPlayer(contact)) {
            // if the drop is visble and player colides with the drop,
            // the item disapears (won't respawn if opening treasure chest again)
            if (isFixtureB(contact, Axe.class)){
                if (((Axe)contact.getFixtureB().getUserData()).isVisible() && !(((Axe) contact.getFixtureB().getUserData()).isPicked())){
                    ((Axe)contact.getFixtureB().getUserData()).setPicked(true);
                    System.out.println("axe picked");
                }
            }else {
                if (((Axe)contact.getFixtureA().getUserData()).isVisible() && !(((Axe) contact.getFixtureA().getUserData()).isPicked())){
                    ((Axe)contact.getFixtureA().getUserData()).setPicked(true);
                    System.out.println("axe picked");
                }
            }

        }

        if (isWorldObject(contact, Sword.class) && isPlayer(contact)) {
            // if the drop is visble and player colides with the drop,
            // the item disapears (won't respawn if opening treasure chest again)
            if (isFixtureB(contact,Sword.class)){
                if (((Sword)contact.getFixtureB().getUserData()).isVisible() && !((Sword) contact.getFixtureB().getUserData()).isPicked() ){
                    ((Sword)contact.getFixtureB().getUserData()).setPicked(true);
                    System.out.println("sword picked");
                }
            }else {
                if (((Sword)contact.getFixtureA().getUserData()).isVisible() && !((Sword) contact.getFixtureA().getUserData()).isPicked() ){
                    ((Sword)contact.getFixtureA().getUserData()).setPicked(true);
                    System.out.println("sword picked");
                }
            }

        }
        //***END OF*** contact listener for WorldObjects and items***
    }

    @Override
    public void endContact(Contact contact) {
        //when player no longer is in contact, trasure closes.
        if (isWorldObject(contact, Treasure.class)) {
            if (isFixtureB(contact,Treasure.class)) {
                ((Treasure) contact.getFixtureB().getUserData()).setIsOpen(false);
            }else {
                ((Treasure) contact.getFixtureA().getUserData()).setIsOpen(false);
            }
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }

    //check if the player is actully the one contact or get contacted by another object.
    public boolean isPlayer(Contact contact) {
        if (!isFixtrueNull(contact)){
            return (contact.getFixtureA().getUserData() instanceof EntityPlayerKelde
                    || contact.getFixtureB().getUserData() instanceof  EntityPlayerKelde);
        }else {
            return false;
        }

    }

    //checks if the contacted object actully is the object u are looking for.
    public boolean isWorldObject(Contact contact, Class object){
        if (!isFixtrueNull(contact)){
            return (contact.getFixtureA().getUserData().getClass().isAssignableFrom(object)
                    || contact.getFixtureB().getUserData().getClass().isAssignableFrom(object));
        }else {
            return false;
        }

    }
    //checks if checks with fixture the object is
    public boolean isFixtureA(Contact contact, Class object){
        return (contact.getFixtureA().getUserData().getClass().isAssignableFrom(object));
    }
    public boolean isFixtureB(Contact contact, Class object){
        return (contact.getFixtureB().getUserData().getClass().isAssignableFrom(object));
    }

    //checks if the fixture with got contacted is null, if so return true else false.
    public boolean isFixtrueNull(Contact contact){
        if (contact.getFixtureA().getUserData() == null || contact.getFixtureB() == null){
            return true;
        }else {
            return false;
        }
    }
}