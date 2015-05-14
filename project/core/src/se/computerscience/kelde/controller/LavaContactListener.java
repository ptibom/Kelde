/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import se.computerscience.kelde.model.worldobjects.Door;

public class LavaContactListener implements ContactListener {
    private ScreenChanger screenChanger = ScreenChanger.getInstance();

    @Override
    public void beginContact(Contact contact) {
        Object fixtureA = contact.getFixtureA().getUserData();
        Object fixtureB = contact.getFixtureB().getUserData();

        //*** contact listener for WorldObjects, sensors and items ***
        if ((fixtureA instanceof Door || fixtureB instanceof Door)) {
            screenChanger.setCurrentScreen("Game");
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}