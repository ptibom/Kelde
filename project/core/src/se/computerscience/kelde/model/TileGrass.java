/* Description: Tile that looks like grass.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model;

public class TileGrass implements ITiles {
    public boolean canWalk = true;

    @Override
    public boolean canWalk() {
        return canWalk;
    }
}
