/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.model.items.Sword;
import se.computerscience.kelde.view.items.SwordView;


public class SwordController implements IWorldObjectsController, IItemController {
    Sword sword;
    SwordView swordView;
    private boolean picked = false;
    public SwordController(Sword sword,SwordView swordView) {
        this.sword = sword;
        this.swordView = swordView;
    }
    public void setVisble(boolean visble){
        swordView.setVisble(visble);
    }

    public boolean isVisble() {
        return swordView.isVisble();
    }

    public boolean isPicked() {
        return picked;
    }

    @Override
    public void update(float delta) {

    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }
}
