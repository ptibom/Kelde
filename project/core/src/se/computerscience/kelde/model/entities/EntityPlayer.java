/** Description: This is a player controlled character with base-stats. The used player character will be extend this class for modularity.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

public class EntityPlayer implements IPlayerEntity {
    private int health = 100;
    private int mana = 100;
    private int strength = 10;
    private int magic = 10;

    /* Getters & Setters */
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getMagic() {
        return magic;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void setMagic(int magic) {
        this.magic = magic;
    }
}
