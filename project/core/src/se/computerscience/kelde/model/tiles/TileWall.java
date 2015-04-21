/** Description: Tiles, like grass and water. But should stop Entities from moving.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.tiles;

public class TileWall implements ITiles {
    public boolean canWalk = false;

    @Override
    public boolean canWalk() {
        return canWalk;
    }
}
