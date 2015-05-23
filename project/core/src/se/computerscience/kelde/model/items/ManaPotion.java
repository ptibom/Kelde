/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.libgdx.Atlas;

public class ManaPotion extends Item {
    private final boolean isConsumable = true;
    private final boolean isWeapon = false;
    private final int mana = 20;
    public ManaPotion() {
    }
    @Override
    protected void setRegion() {
        region.setRegion(textureAtlas.findRegion("0002"));
    }

    @Override
    protected void setTextureAtlas() {
        textureAtlas = new Atlas("potion.atlas");
    }

    public int getMana() {
        return mana;
    }

    @Override
    public boolean isConsumable() {
        return isConsumable;
    }
    @Override
    public boolean isWeapon() {
        return isWeapon;
    }
}