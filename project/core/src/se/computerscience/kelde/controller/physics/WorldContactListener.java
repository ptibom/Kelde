/**
 * Description: Receives events for collisions in the world.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller.physics;

import se.computerscience.kelde.controller.entities.EntityBatController;
import se.computerscience.kelde.controller.entities.EntityEyeController;
import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import se.computerscience.kelde.controller.entities.EntityArrowController;
import se.computerscience.kelde.model.encapsulation.IMonster;

import se.computerscience.kelde.model.entities.EntityArrow;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;


import se.computerscience.kelde.model.worldobjects.IWorldObjects;

import java.util.Iterator;
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

        // Check whether player is involved in the collision
        if (objectA instanceof EntityPlayerKelde) {
            if (objectB instanceof IWorldObjects) {
                eventCache.add(new CollisionEvent(state, objectB));
            }
        }
        else if (objectB instanceof EntityPlayerKelde) {
            if (objectA instanceof IWorldObjects) {
                eventCache.add(new CollisionEvent(state, objectA));
            }
        }
        /*if (objectA instanceof EntityArrow && objectB instanceof IMonster) {
            System.out.println("objectA is instanceof EntityArrowasdasdasdasd");
        } else if (objectB instanceof EntityArrow && objectA instanceof EntityBatController) {
            MonsterEventBus.INSTANCE.publish(new MonsterEvent(objectA));
        } else if (objectB instanceof EntityArrow && objectA instanceof EntityEyeController) {
            MonsterEventBus.INSTANCE.publish(new MonsterEvent(objectA));
        }*/
        if (objectA instanceof EntityArrow && objectB instanceof IMonster){
            MonsterEventBus.INSTANCE.publish(new MonsterEvent(objectA));
        }else if (objectB instanceof EntityArrow && objectA instanceof IMonster){
            MonsterEventBus.INSTANCE.publish(new MonsterEvent(objectA));
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