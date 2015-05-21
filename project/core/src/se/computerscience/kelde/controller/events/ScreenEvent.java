package se.computerscience.kelde.controller.events;

/**
 * Description: Screen event
 *
 * @author: Philip Tibom
 */
public class ScreenEvent {
    public enum Tag {
        SET_SCREEN
    }
    private final Tag tag;
    private final Object object;

    public ScreenEvent(Tag tag, Object object) {
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
