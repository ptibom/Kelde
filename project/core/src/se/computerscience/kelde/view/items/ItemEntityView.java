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

    public ItemEntityView(ItemEntity itemEntity) {
        this.itemEntity = itemEntity;
    }

    @Override
    public void draw(SpriteBatch batch) {
        itemEntity.getItem().getSprite().setPosition(itemEntity.getPositionX(), itemEntity.getPositionY());
        itemEntity.getItem().getSprite().draw(batch);
    }

    public ItemEntity getItemEntity() {
        return itemEntity;
    }
}