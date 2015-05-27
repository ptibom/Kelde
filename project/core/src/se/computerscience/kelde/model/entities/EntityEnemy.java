/** Description: Hostile entity, should attack player.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

public class EntityEnemy implements INPCEntity {
    private final static boolean FRIENDLY = false;

    @Override
    public boolean isFriendly() {
        return FRIENDLY;
    }
}
