/**
 * Description: A sword item. Used by player to damage enemies.
 *
 * @author: Philip Tibom
 * @co-author Hossein Husain
 */

package se.computerscience.kelde.model.items;

public class Sword extends Item {
    private final static boolean CONSUMABLE = false;
    private final static boolean WEAPON = true;
    private final static int DAMAGE = 10;

    public int getDamage() {
        return DAMAGE;
    }

    @Override
    protected void setRegion() {
        region.setRegion(textureAtlas.getTextureAtlas().findRegion("0001"));
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