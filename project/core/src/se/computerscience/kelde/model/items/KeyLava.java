/**
 * Description:
 *
 * @author: Hossein Hussain
 */

package se.computerscience.kelde.model.items;

public class KeyLava extends Item {
    private boolean isConsumable = true;
    private boolean isWeapon = false;
    public KeyLava() {
    }

    @Override
    protected void setRegion() {
        region = textureAtlas.findRegion("0004");
    }
}