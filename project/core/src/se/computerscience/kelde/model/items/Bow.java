/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.items;

public class Bow extends Item {
    private final boolean isConsumable = false;
    private final boolean isWeapon = true;
    private final int damage = 10;
    public Bow() {
    }

    @Override
    protected void setRegion() {
        this.region = textureAtlas.findRegion("0003");
    }

    public int getDamage() {
        return damage;
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