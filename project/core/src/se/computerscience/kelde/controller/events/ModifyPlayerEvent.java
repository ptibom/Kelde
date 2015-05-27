/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.events;

public class ModifyPlayerEvent {
    public enum Tag {
        CHANGE_POS;
    }

    private final Tag tag;
    private final Object object;

    public ModifyPlayerEvent(Tag tag, Object object) {
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