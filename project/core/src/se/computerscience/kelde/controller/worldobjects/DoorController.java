/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.model.worldobjects.Door;
import se.computerscience.kelde.view.worldobjects.DoorView;

public class DoorController implements IWorldObjectsController {
    Door door;
    DoorView doorView;

    public DoorController(Door door, DoorView doorView) {
        this.door = door;
        this.doorView = doorView;
    }

    @Override
    public void update(float delta) {

    }
}
