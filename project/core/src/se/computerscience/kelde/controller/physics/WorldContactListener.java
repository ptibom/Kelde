/**
 * Description: Receives events for collisions in the world.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller.physics;

import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import se.computerscience.kelde.model.entities.INPCEntity;

import java.util.concurrent.ConcurrentLinkedQueue;


public class WorldContactListener implements ContactListener, ICollisionEventHandler {
    // Use cache to wait for concurrency locks
    private final ConcurrentLinkedQueue<CollisionEvent> eventCache = new ConcurrentLinkedQueue<>();

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
        while (!eventCache.isEmpty()) {
            CollisionEventBus.INSTANCE.publish(eventCache.poll());
        }
    }

    // Suppress PMD warning because the IF-statement would get really long if combined.
    @SuppressWarnings("PMD.CollapsibleIfStatements")
    public void computeCollision(Contact contact, CollisionEvent.Tag state) {
        final Object objectA = contact.getFixtureA().getUserData();
        final Object objectB = contact.getFixtureB().getUserData();
        if (objectA == null || objectB == null) {
            return;
        }

        // Check whether player is involved in the collision
        if (objectA instanceof EntityPlayerKelde) {
            eventCache.add(new CollisionEvent(state, objectB));
            if (objectB instanceof INPCEntity) {
               final INPCEntity npc = (INPCEntity) objectB;
                if (!npc.isFriendly() && state == CollisionEvent.Tag.BEGIN) {
                    ModifyPlayerEventBus.INSTANCE.publish(new ModifyPlayerEvent(ModifyPlayerEvent.Tag.DAMAGE, 10));
                }
            }
        }
        else if (objectB instanceof EntityPlayerKelde) {
            eventCache.add(new CollisionEvent(state, objectA));
            if (objectA instanceof INPCEntity) {
               final INPCEntity npc = (INPCEntity) objectB;
                if (!npc.isFriendly() && state == CollisionEvent.Tag.BEGIN) {
                    ModifyPlayerEventBus.INSTANCE.publish(new ModifyPlayerEvent(ModifyPlayerEvent.Tag.DAMAGE, 10));
                }
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