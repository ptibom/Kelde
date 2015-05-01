/** Description: Interface to abstract Player Entity. In case we want several players in the future.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

public interface IPlayerEntity {
    public int getHealth();
    public int getMana();
    public int getStrength();
    public int getMagic();
    public void setHealth(int health);
    public void setMana(int mana);
    public void setStrength(int strength);
    public void setMagic(int magic);
}
