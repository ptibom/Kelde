/* Description: This is a player controlled character with base-stats. The used player character will be extend this class for modularity.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

public class EntityPlayer implements IPlayerEntity {
    private int health = 100;
    private int mana = 100;
    private int strength = 10;
    private int intelligence = 10;

    /* Getters */
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
    public int getIntelligence() {
        return intelligence;
    }

    /* Temporary setters */
    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
