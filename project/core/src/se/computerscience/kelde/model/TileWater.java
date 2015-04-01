/* Description: Water tile. Entities cannot walk on it.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model;

public class TileWater implements ITiles {
    public boolean canWalk = false;

    @Override
    public boolean canWalk() {
        return canWalk;
    }
}
