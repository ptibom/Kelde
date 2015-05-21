/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.items;


public class Key_Lava extends Item {
    private boolean isConsumable = true;
    private boolean isWeapon = false;
    public Key_Lava() {
    }

    @Override
    protected void setRegion() {
        this.region = textureAtlas.findRegion("0004");
    }
}