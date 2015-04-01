/* Description: Interface to abstract various game-items that a player can use.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model;

public interface IItems {
    public boolean isConsumable();
    public boolean isWeapon();
}
