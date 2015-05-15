/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.model.worldobjects.Bomb;
import se.computerscience.kelde.view.worldobjects.BombView;

public class BombController implements  IWorldObjectsController {
    private Bomb bomb;
    private BombView bombView;
    private int i=0;

    public BombController(Bomb bomb, BombView bombView) {
        this.bomb = bomb;
        this.bombView = bombView;
    }

    @Override
    public void update(float delta) {
        if (bomb.isDetonate()){
            bombView.update(delta);
        }
    }
}