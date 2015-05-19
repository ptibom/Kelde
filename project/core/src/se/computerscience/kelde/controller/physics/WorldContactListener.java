/**
 * Description: Receives events for collisions in the world.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller.physics;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.CollisionEventBus;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.items.IItems;
import se.computerscience.kelde.model.worldobjects.IWorldObjects;


public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        computeCollision(contact, CollisionEvent.Tag.BEGIN);
    }

    @Override
    public void endContact(Contact contact) {
        computeCollision(contact, CollisionEvent.Tag.END);

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }

    public void computeCollision(Contact contact, CollisionEvent.Tag state) {
        Object objectA = contact.getFixtureA().getUserData();
        Object objectB = contact.getFixtureB().getUserData();

        // Check whether player is involved in the collision
        if (objectA instanceof EntityPlayerKelde) {
            if (objectB instanceof IItems || objectB instanceof IWorldObjects) {
                CollisionEventBus.INSTANCE.publish(new CollisionEvent(state, objectB));
            }
        }
        else if (objectB instanceof EntityPlayerKelde) {
            if (objectA instanceof IItems || objectA instanceof IWorldObjects) {
                CollisionEventBus.INSTANCE.publish(new CollisionEvent(state, objectA));
            }
        }
    }
}