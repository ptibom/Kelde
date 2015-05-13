/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.model.worldobjects.Treasure;
import se.computerscience.kelde.view.worldobjects.TreasureView;

public class TreasureController implements IWorldObjectsController {
    Treasure treasure;
    TreasureView treasureView;

    public TreasureController(Treasure treasure, TreasureView treasureView) {
        this.treasure = treasure;
        this.treasureView = treasureView;
    }

    public void update(float delta) {
        treasureView.update(delta);
    }
}