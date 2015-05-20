/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller.events;

public class CollisionEvent {
    public enum Tag {
        BEGIN, END, SEND_CACHE
    }
    private final Tag tag;
    private final Object object;

    public CollisionEvent(Tag tag, Object object) {
        this.tag = tag;
        this.object = object;
    }

    public Tag getTag() {
        return tag;
    }

    public Object getObject() {
        return object;
    }
}
