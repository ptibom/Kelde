package se.computerscience.kelde.events;

/**
 * Description: Screen event
 *
 * @author: Philip Tibom
 */
public class ScreenEvent {
    public enum Tag {
        SET_SCREEN
    }
    public enum ScreenTag {
        START_WORLD, LAVA_WORLD, START_MENU, START_INTRO
    }

    private final Tag tag;
    private final ScreenTag screenTag;

    public ScreenEvent(Tag tag, ScreenTag screenTag) {
        this.tag = tag;
        this.screenTag = screenTag;
    }

    public Tag getTag() {
        return tag;
    }

    public ScreenTag getScreenTag() {
        return screenTag;
    }
}
