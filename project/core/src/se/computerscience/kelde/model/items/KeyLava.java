/**
 * Description:
 *
 * @author: Hossein Hussain
 */

package se.computerscience.kelde.model.items;

public class KeyLava extends Item {
    private final static boolean CONSUMABLE = true;
    private final static boolean WEAPON = false;


    @Override
    protected void setRegion() {
        region.setRegion(textureAtlas.findRegion("0004"));
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