/* Description: Interface to abstract Player Entity. In case we want several players in the future.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model;

public interface IPlayerEntity {
    public int getHealth();
    public int getMana();
    public int getStrength();
    public int getIntelligence();
}
