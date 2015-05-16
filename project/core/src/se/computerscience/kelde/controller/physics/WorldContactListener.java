/**
 * Description: ContactListener
 *
 * @author: Hossein Hussain
 */

package se.computerscience.kelde.controller.physics;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.model.items.Sword;
import se.computerscience.kelde.model.worldobjects.Door;
import se.computerscience.kelde.model.worldobjects.Treasure;

public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Object fixtureA = contact.getFixtureA().getUserData();
        Object fixtureB = contact.getFixtureB().getUserData();

        //*** contact listener for WorldObjects, sensors and items ***
        if ((fixtureA instanceof Door || fixtureB instanceof Door) && isPlayer(contact)) {
            System.out.println("kelde just pressed a sensor");
        }

        if ((fixtureA instanceof Treasure || fixtureB instanceof Treasure) && isPlayer(contact)){
            if (fixtureB instanceof Treasure){
                ((Treasure) contact.getFixtureB().getUserData()).setIsOpen(true);
                ((Treasure) contact.getFixtureB().getUserData()).setVisble();
            }else {
                ((Treasure) contact.getFixtureA().getUserData()).setIsOpen(true);
                ((Treasure) contact.getFixtureA().getUserData()).setVisble();
            }
        }

        if ((fixtureA instanceof Axe || fixtureB instanceof Axe) && isPlayer(contact)) {
            // if the drop is visble and player colides with the drop,
            // the item disapears (won't respawn if opening treasure chest again)
            if (fixtureB instanceof Axe){
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

        if ((fixtureA instanceof Sword || fixtureB instanceof Sword) && isPlayer(contact) ) {
            // if the drop is visble and player colides with the drop,
            // the item disapears (won't respawn if opening treasure chest again)
            if (fixtureB instanceof Sword){
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
        Object fixtureA = contact.getFixtureA().getUserData();
        Object fixtureB = contact.getFixtureB().getUserData();

        //when player no longer is in contact, trasure closes.
        if ((fixtureA instanceof Treasure || fixtureB instanceof Treasure) && isPlayer(contact)) {
            if (fixtureB instanceof Treasure) {
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
        return (contact.getFixtureA().getUserData() instanceof EntityPlayerKelde
                || contact.getFixtureB().getUserData() instanceof  EntityPlayerKelde);
    }
}