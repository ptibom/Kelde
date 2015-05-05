package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.gameworld.IWorldObjectsController;
import se.computerscience.kelde.model.items.AxeModel;
import se.computerscience.kelde.view.items.AxeView;
/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class AxeController implements IWorldObjectsController {
    AxeModel axeModel;
    AxeView axeView;
    private boolean picked = false;
    public AxeController(AxeModel axeModel, AxeView axeView) {
        this.axeModel = axeModel;
        this.axeView = axeView;
    }
    public void update(float delta){
        //
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
}