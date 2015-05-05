package se.computerscience.kelde.controller.gameworld;

import se.computerscience.kelde.model.gameworld.BarrelModel;
import se.computerscience.kelde.view.gameworld.BarrelView;

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class BarrelController implements IWorldObjectsController {
    BarrelModel barrelModel;
    BarrelView barrelView;
    public BarrelController(BarrelModel barrelModel, BarrelView barrelView) {
        this.barrelModel = barrelModel;
        this.barrelView = barrelView;
    }
    public void update(float delta){
        barrelModel.barrelMovement();
    }


}
