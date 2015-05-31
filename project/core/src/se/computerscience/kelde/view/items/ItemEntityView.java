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
    private final ItemEntity itemEntity;

    public ItemEntityView(ItemEntity itemEntity) {
        this.itemEntity = itemEntity;
    }

    @Override
    public void draw(SpriteBatch batch) {
        itemEntity.getItem().getItemSprite().getSprite().setPosition(itemEntity.getPositionX(), itemEntity.getPositionY());
        itemEntity.getItem().getItemSprite().getSprite().draw(batch);
    }
}