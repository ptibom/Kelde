/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.libgdx.Atlas;

public class HealthPotion extends Item {
    private final boolean isConsumable = true;
    private final boolean isWeapon = false;
    private final int health = 20;
    public HealthPotion() {
    }
    @Override
    protected void setRegion() {
        region.setRegion(textureAtlas.findRegion("0001"));
    }

    @Override
    protected void setTextureAtlas() {
        textureAtlas = new Atlas("potion.atlas");
    }

    public int getHealth() {
        return health;
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