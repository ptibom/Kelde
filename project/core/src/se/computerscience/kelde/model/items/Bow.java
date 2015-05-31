/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.items;

public class Bow extends Item {
    private final static boolean CONSUMABLE = false;
    private final static boolean WEAPON = true;
    private final static int DAMAGE = 10;

    @Override
    protected void setRegion() {
        region.setRegion(textureAtlas.findRegion("0003"));
    }

    public int getDamage() {
        return DAMAGE;
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