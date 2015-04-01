/* Description: Hostile entity, should attack player.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model;

public class EntityEnemy implements INPCEntity {
    private boolean isFriendly = false;

    @Override
    public boolean isFriendly() {
        return isFriendly;
    }
}
