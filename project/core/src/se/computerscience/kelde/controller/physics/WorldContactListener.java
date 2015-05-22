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
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.items.IItems;
import se.computerscience.kelde.model.worldobjects.IWorldObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class WorldContactListener implements ContactListener, ICollisionEventHandler {
    // Use cache to wait for concurrency locks
    private final List<CollisionEvent> eventCache = new ArrayList<>();

    public WorldContactListener() {
        CollisionEventBus.INSTANCE.register(this);
    }

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
        // Not needed
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        // Not needed
    }

    public void executeCache() {
        final Iterator<CollisionEvent> eventCacheIt = eventCache.iterator();
        while (eventCacheIt.hasNext()) {
            final CollisionEvent event = eventCacheIt.next();
            CollisionEventBus.INSTANCE.publish(event);
            eventCacheIt.remove();
        }
    }

    // Suppress PMD warning because the IF-statement would get really long if combined.
    @SuppressWarnings("PMD.CollapsibleIfStatements")
    public void computeCollision(Contact contact, CollisionEvent.Tag state) {
        final Object objectA = contact.getFixtureA().getUserData();
        final Object objectB = contact.getFixtureB().getUserData();

        // Check whether player is involved in the collision
        if (objectA instanceof EntityPlayerKelde) {
            if (objectB instanceof IItems || objectB instanceof IWorldObjects) {
                eventCache.add(new CollisionEvent(state, objectB));
            }
        }
        else if (objectB instanceof EntityPlayerKelde) {
            if (objectA instanceof IItems || objectA instanceof IWorldObjects) {
                eventCache.add(new CollisionEvent(state, objectA));
            }
        }
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getTag() == CollisionEvent.Tag.SEND_CACHE) {
            executeCache();
        }
    }

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }
}