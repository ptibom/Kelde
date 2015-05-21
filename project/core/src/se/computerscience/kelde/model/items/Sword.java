/** Description: A sword item. Used by player to damage enemies.
 *  @author: Philip Tibom
 *  @co-author Hossein Husain
 */

package se.computerscience.kelde.model.items;

public class Sword extends Item {
    private boolean isConsumable = false;
    private boolean isWeapon = true;
    private final int damage = 10;
    public Sword() {
    }
    public int getDamage() {
        return damage;
    }

    @Override
    protected void setRegion() {
        region.setRegion(textureAtlas.getTextureAtlas().findRegion("0001"));
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