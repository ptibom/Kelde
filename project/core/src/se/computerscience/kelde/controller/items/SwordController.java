/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.model.items.Sword;
import se.computerscience.kelde.view.items.SwordView;


public class SwordController implements IWorldObjectsController, IItemController{
    Sword sword;
    SwordView swordView;
    private boolean picked = false;
    public SwordController(Sword sword,SwordView swordView) {
        this.sword = sword;
        this.swordView = swordView;
    }
    @Override
    public void setVisble(boolean visble){
        swordView.setVisble(visble);
    }
    @Override
    public boolean isVisble() {
        return swordView.isVisble();
    }
    @Override
    public boolean isPicked() {
        return picked;
    }
    @Override
    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    @Override
    public void update(float delta) {
        if (sword.isVisible()){
            if (!this.isPicked()){
                this.setVisble(true);
            }
        }
        if (sword.isPicked()){
            this.setPicked(true);
            this.setVisble(false);
        }
    }

}
