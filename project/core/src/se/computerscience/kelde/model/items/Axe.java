package se.computerscience.kelde.model.items;


/**
 * Description: An axe-item, makes damage.
 *
 * @author: Hossein Hussain
 */
public class Axe extends Item {
    private final boolean isConsumable = false;
    private final boolean isWeapon = true;
    private final int damage = 10;
    public Axe() {
    }
    @Override
    protected void setRegion() {
        region.setRegion(textureAtlas.findRegion("0002"));
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