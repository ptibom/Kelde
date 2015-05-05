package se.computerscience.kelde;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import se.computerscience.kelde.controller.gameworld.IWorldObjectsController;
import se.computerscience.kelde.controller.gameworld.TreasureController;
import se.computerscience.kelde.controller.items.AxeController;
import se.computerscience.kelde.controller.items.SwordController;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;

/**
 * Description: ContactListener
 *
 * @author: Hossein Hussain
 */
public class WorldContactListener implements ContactListener {

    IWorldObjectsController[] worldObjects;
    public WorldContactListener(IWorldObjectsController[] worldObjects) {
        this.worldObjects = worldObjects;
    }


    @Override
    public void beginContact(Contact contact) {

        //***contact listener for WorldObjects and items***
        if (isObject("treasure 1",contact) && isPlayer(contact)){
            ((TreasureController)worldObjects[1]).openTreasure();

            if (!(((AxeController)worldObjects[4]).isPicked()))
                ((AxeController)worldObjects[4]).setVisble(true); // making a drop visble when player open treasure chest
        }

        if (isObject("treasure 2",contact) && isPlayer(contact)){
            ((TreasureController)worldObjects[3]).openTreasure();
            if (!(((SwordController)worldObjects[5]).isPicked()))
                ((SwordController)worldObjects[5]).setVisble(true); // making a drop visble when player open treasure chest
        }



        if (isObject("barrel 1",contact) && isPlayer(contact))
            System.out.println("barrel 1");

        if (isObject("axe 1",contact) && isPlayer(contact) ){
            // if the drop is visble and player colides with the drop,
            // the item disapears (won't respawn if opening treasure chest again)
            if (((AxeController)worldObjects[4]).isVisble()){
                ((AxeController)worldObjects[4]).setPicked(true);
                ((AxeController)worldObjects[4]).setVisble(false);
                System.out.println("kelde just picked up the axe");
                // add code to put the axe in keldes inventory here
            }
        }

        if (isObject("sword 1",contact) && isPlayer(contact) ){
            // if the drop is visble and player colides with the drop,
            // the item disapears (won't respawn if opening treasure chest again)
            if (((SwordController)worldObjects[5]).isVisble()){
                ((SwordController)worldObjects[5]).setPicked(true);
                ((SwordController)worldObjects[5]).setVisble(false);
                System.out.println("kelde just picked up the sword");
                // add code to put the axe in keldes inventory here
            }
        }
        //***END OF***contact listener for WorldObjects and items***
    }

    @Override
    public void endContact(Contact contact) {
        if (isObject("treasure 1",contact) && isPlayer(contact))
            ((TreasureController)worldObjects[1]).closeTreasure();
        else if (isObject("treasure 2",contact) && isPlayer(contact))
            ((TreasureController)worldObjects[3]).closeTreasure();
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
    //checking if the contacted is the input userdata
    public boolean isObject(String userdata, Contact contact){
        return contact.getFixtureB().getUserData().equals(userdata);
    }
    //checks if the players collided
    public boolean isPlayer(Contact contact){
        return contact.getFixtureA().getUserData() instanceof EntityPlayerKelde;
    }
}
