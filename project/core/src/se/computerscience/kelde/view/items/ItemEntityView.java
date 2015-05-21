/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
            itemEntity.getItem().getSpriteEncaps().getSprite().setPosition(itemEntity.getPositionX(), itemEntity.getPositionY());
            itemEntity.getItem().getSpriteEncaps().getSprite().draw(batch);
        }
        if (delete){
            itemEntity.playerPickUp();
            delete = false;
        }
    }
    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}