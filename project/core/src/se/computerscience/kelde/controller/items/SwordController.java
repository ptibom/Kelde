/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.gameworld.IWorldObjectsController;
import se.computerscience.kelde.model.items.SwordModel;
import se.computerscience.kelde.view.items.SwordView;


public class SwordController implements IWorldObjectsController,IitemController{
    SwordModel swordModel;
    SwordView swordView;
    private boolean picked = false;
    public SwordController(SwordModel swordModel,SwordView swordView) {
        this.swordModel = swordModel;
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

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    @Override
    public String itemName() {
        return "sword 1";
    }
}
