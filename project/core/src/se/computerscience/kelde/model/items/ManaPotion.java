/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.libgdx.Atlas;

public class ManaPotion extends Item {
    private final static boolean CONSUMABLE = true;
    private final static boolean WEAPON = false;
    private final static int MANA = 20;

    @Override
    protected void setRegion() {
        region.setRegion(textureAtlas.findRegion("0002"));
    }

    @Override
    protected void setTextureAtlas() {
        textureAtlas = new Atlas("potion.atlas");
    }

    public int getMana() {
        return MANA;
    }

    @Override
    public boolean isConsumable() {
        return CONSUMABLE;
    }
    @Override
    public boolean isWeapon() {
        return WEAPON;
    }
}