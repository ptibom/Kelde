/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.view.items.AxeView;

public class AxeController implements IItemController, ICollisionEventHandler, IItemEventHandler{
   // private Axe axe;
   // private AxeView axeView;
    private boolean destroyed = false;
    public AxeController(Axe axe, AxeView axeView) {
      //  this.axe = axe;
       // this.axeView = axeView;
        CollisionEventBus.INSTANCE.register(this);
        ItemEventBus.INSTANCE.register(this);
    }
    public void update(float delta) {
      /*  if (destroyed){
            axe.destroy();
            destroyed = false;
        }
    */}

    @Override
    public void onCollisionEvent(CollisionEvent event) {
      /*  if (event.getObject() != axe) {
            return;
        }
        if (axe.isVisible()) {
            axe.setPicked(true);
            destroyed = true;
        }
    */}

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }

    @Override
    public void onEvent(ItemEvent event) {
        /*if (event.getObject() != axe){
            return;
        }
        axe.setVisible(true);
    */}
}