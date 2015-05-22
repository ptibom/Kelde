/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.events;

public class ItemEvent {
    public enum Tag {
        ITEM,
        ITEM_ENTITY,
        DEL_VIEW;
    }
    private final Tag tag;
    private final Object object;

    public ItemEvent(Tag tag, Object object) {
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