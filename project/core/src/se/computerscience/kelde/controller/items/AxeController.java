/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.view.items.AxeView;

public class AxeController implements IWorldObjectsController,IItemController {
    Axe axe;
    AxeView axeView;
    private boolean picked = false;
    public AxeController(Axe axe, AxeView axeView) {
        this.axe = axe;
        this.axeView = axeView;
    }
    public void setVisble(boolean visble){
        axeView.setVisble(visble);
    }

    public boolean isVisble() {
        return axeView.isVisble();
    }

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    @Override
    public void update(float delta) {
        if (axe.isVisible()){
            if (!this.isPicked()){
                this.setVisble(true);
            }
        }
        if (axe.isPicked()){
            this.setPicked(true);
            this.setVisble(false);
        }
    }

}