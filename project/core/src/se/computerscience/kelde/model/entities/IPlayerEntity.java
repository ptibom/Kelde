/**
 * Description: Interface to abstract Player Entity. In case we want several players in the future.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

public interface IPlayerEntity {
    int getHealth();

    int getMana();

    int getStrength();

    int getMagic();

    int getDirection();

    void setHealth(int health);

    void setMana(int mana);

    void setStrength(int strength);

    void setMagic(int magic);

    void setDirection(int direction);
}
