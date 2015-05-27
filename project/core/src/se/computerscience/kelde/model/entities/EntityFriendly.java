/** Description: Friendly entity, should talk to player.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

public class EntityFriendly implements INPCEntity {
    private static final boolean FRIENDLY = true;

    @Override
    public boolean isFriendly() {
        return FRIENDLY;
    }
}
