/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.CollisionEventBus;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.view.items.AxeView;

public class AxeController implements IItemController, ICollisionEventHandler{
    Axe axe;
    AxeView axeView;
    private boolean picked = false;
    public AxeController(Axe axe, AxeView axeView) {
        this.axe = axe;
        this.axeView = axeView;
        CollisionEventBus.INSTANCE.register(this);
    }
    @Override
    public void setVisble(boolean visble){
        axeView.setVisble(visble);
    }
    @Override
    public boolean isVisble() {
        return axeView.isVisble();
    }
    @Override
    public boolean isPicked() {
        return picked;
    }
    @Override
    public void setPicked(boolean picked) {
        this.picked = picked;
    }

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

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != axe) {
            return;
        }
        if (axe.isVisible()) {
            axe.setPicked(true);
        }
    }

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }
}