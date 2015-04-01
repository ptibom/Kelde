/* Description: Friendly entity, should talk to player.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model;

public class EntityFriendly implements INPCEntity {
    private boolean isFriendly = true;

    @Override
    public boolean isFriendly() {
        return isFriendly;
    }
}
