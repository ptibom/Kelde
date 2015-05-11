/**
 * Description: ContactListener
 *
 * @author: Hossein Hussain
 */

package se.computerscience.kelde;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import se.computerscience.kelde.controller.entities.EntityPlayerKeldeController;
import se.computerscience.kelde.controller.gameworld.IWorldObjectsController;
import se.computerscience.kelde.controller.gameworld.TreasureController;
import se.computerscience.kelde.controller.items.AxeController;
import se.computerscience.kelde.controller.items.IitemController;
import se.computerscience.kelde.controller.items.SwordController;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.screens.GameScreen;

import java.util.List;


public class WorldContactListener implements ContactListener {
    List<IWorldObjectsController> worldObjects;
    public WorldContactListener(List<IWorldObjectsController> worldObjects) {
        this.worldObjects = worldObjects;
    }

    @Override
    public void beginContact(Contact contact) {
        //***contact listener for WorldObjects, sensors and items ***
        if (isObject("sensor 1",contact) && isPlayer(contact)){
            System.out.println("kelde just pressed a sensor");
        }

        if (isObject("treasure 1",contact) && isPlayer(contact)) {
            ((TreasureController)worldObjects.get(1)).openTreasure();  // when player touch the object it will run openTreasure metod!

            if (!(((AxeController)worldObjects.get(4)).isPicked()))   // checks if the items is not already picked
                ((AxeController)worldObjects.get(4)).setVisble(true); // making a drop visble when player open treasure chest
        }

        if (isObject("treasure 2",contact) && isPlayer(contact)){
            ((TreasureController)worldObjects.get(3)).openTreasure();   // when player colides, will run openTreasure
            if (!(((SwordController)worldObjects.get(5)).isPicked()))   // checks if the items is not already picked
                ((SwordController)worldObjects.get(5)).setVisble(true); // making a drop visble when player open treasure chest
        }

        if (isObject("axe 1",contact) && isPlayer(contact) ){
            // if the drop is visble and player colides with the drop,
            // the item disapears (won't respawn if opening treasure chest again)

            if (((AxeController)worldObjects.get(4)).isVisble()){
                ((AxeController)worldObjects.get(4)).setPicked(true);
                ((AxeController)worldObjects.get(4)).setVisble(false);
                System.out.println("kelde just picked up the axe");
                // add code to put the axe in keldes inventory here
                ((EntityPlayerKeldeController)worldObjects.get(2)).getPlayerInventory().addToIventory((IitemController)worldObjects.get(4));
            }
        }

        if (isObject("sword 1",contact) && isPlayer(contact) ){
            // if the drop is visble and player colides with the drop,
            // the item disapears (won't respawn if opening treasure chest again)
            if (((SwordController)worldObjects.get(5)).isVisble()){
                ((SwordController)worldObjects.get(5)).setPicked(true);
                ((SwordController)worldObjects.get(5)).setVisble(false);
                System.out.println("kelde just picked up the sword");
                // add code to put the axe in keldes inventory here
                ((EntityPlayerKeldeController)worldObjects.get(2)).getPlayerInventory().addToIventory((IitemController)worldObjects.get(5));
            }
        }
        //***END OF*** contact listener for WorldObjects and items***
    }

    @Override
    public void endContact(Contact contact) {
        if (isObject("treasure 1",contact) && isPlayer(contact) )
            ((TreasureController)worldObjects.get(1)).closeTreasure();
        else if (isObject("treasure 2",contact) && isPlayer(contact))
           // ((TreasureController)contact.getFixtureB().getUserData()).closeTreasure();
            ((TreasureController)worldObjects.get(3)).closeTreasure();
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }

    //checking if the contacted is the input userdata
    public boolean isObject(String userdata, Contact contact) {
        return contact.getFixtureB().getUserData().equals(userdata);
    }

    //checks if the players collided
    public boolean isPlayer(Contact contact) {
        return contact.getFixtureA().getUserData() instanceof EntityPlayerKelde;
    }
}