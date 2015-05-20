/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.controller.events.ItemEvent;
import se.computerscience.kelde.controller.events.ItemEventBus;
import se.computerscience.kelde.model.worldobjects.ItemEntity;
import se.computerscience.kelde.view.worldobjects.IWorldObjectView;

public class ItemEntityView implements IWorldObjectView {
    private ItemEntity itemEntity;
    private boolean delete = false;
    public ItemEntityView(ItemEntity itemEntity) {
        this.itemEntity = itemEntity;
    }

    @Override
    public void draw(SpriteBatch batch) {
        if (itemEntity.isVisible()) {
            itemEntity.getItem().getSprite().setPosition(itemEntity.getPositionX(), itemEntity.getPositionY());
            itemEntity.getItem().getSprite().draw(batch);
        }
        if (delete){
            System.out.println("we here?");
            itemEntity.playerPickUp();
            delete = false;
        }
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }
}